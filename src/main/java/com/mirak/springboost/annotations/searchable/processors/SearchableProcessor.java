package com.mirak.springboost.annotations.searchable.processors;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mirak.springboost.annotations.searchable.Searchable;
import com.mirak.springboost.annotations.searchable.enums.Type;
import com.mirak.springboost.annotations.searchable.models.SearchableDetails;
import com.mirak.springboost.specifications.models.SearchDetails;
import com.mirak.springboost.specifications.models.SearchModel;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public final class SearchableProcessor {
	
	public static final String SEPARATOR = "#";

	private static final Map<Class<?>, Map<String, SearchableDetails>> searchableDetailsMap = new HashMap<>();

	public static SearchableDetails getInternalSearchableDetailsByTagName(Class<?> clazz, String targetName) {
		Map<String, SearchableDetails> searchMap = getSearchableMap(clazz);
		if (searchMap != null) {
			if (targetName != null && targetName.contains(SEPARATOR) && !searchMap.containsKey(targetName)) {
				List<String> targetNames = Arrays.asList(targetName.split(SEPARATOR));
				SearchableDetails searchableDetails = searchMap.get(targetNames.get(0)).clone();
				StringBuilder targetInternalNameBuilder = new StringBuilder();
				targetInternalNameBuilder.append(searchableDetails.getName());
				for (int i = 1; i < targetNames.size(); i++) {
					String target = targetNames.get(i);
					SearchableDetails fieldSearchableDetails = getInternalSearchableDetailsByTagName(
							searchableDetails.getAttributeClass(), target);
					targetInternalNameBuilder.append(SEPARATOR);
					targetInternalNameBuilder.append(fieldSearchableDetails.getName());
					searchableDetails.setAttributeClass(fieldSearchableDetails.getAttributeClass());
				}
				searchableDetails.setName(targetInternalNameBuilder.toString());
				searchMap.put(targetName, searchableDetails);
				return searchableDetails;
			} else if(targetName != null && !targetName.contains(SEPARATOR) && searchMap.containsKey(targetName)){
				return searchMap.get(targetName);
			}
		}
		return null;
	}
	
	public static Map<String, SearchableDetails> getSearchableMap(Class<?> clazz) {
		if (!searchableDetailsMap.containsKey(clazz)) {
			Field[] fields = clazz.getFields();
			Map<String, SearchableDetails> tagNameToName = new HashMap<>();
			for (int i = 0; i < fields.length; i++) {
				if (SearchableProcessor.isSearchableField(fields[i])) {
					tagNameToName.put(getSearchableTagName(fields[i]), new SearchableDetails(fields[i].getName(),
							getSearchableTagName(fields[i]), getSearchableType(fields[i]), fields[i].getDeclaringClass()));
				}
			}
			searchableDetailsMap.put(clazz, tagNameToName);
			return tagNameToName;
		} else {
			return searchableDetailsMap.get(clazz);
		}
	}

	public static String getSearchableTagName(Field field) {
		return field.getAnnotation(Searchable.class).target();
	}

	public static Type getSearchableType(Field field) {
		return field.getAnnotation(Searchable.class).type();
	}

	public static boolean isSearchableField(Field field) {
		if (field == null) {
			return false;
		}
		return field.isAnnotationPresent(Searchable.class);
	}
	
	public static SearchModel toInternalSearchModel(SearchModel searchModel, Class<?> clazz) {
		SearchModel internalModel = new SearchModel(searchModel.getOperation());
		Map<String, SearchDetails> search = new HashMap<String, SearchDetails>();
		searchModel.getSearch().keySet().forEach(tagName->{
			SearchableDetails searchableDetails = getInternalSearchableDetailsByTagName(clazz, tagName);
			if (searchableDetails != null) {
				search.put(searchableDetails.getName(), searchModel.getSearch().get(tagName));
			}
		});
		internalModel.setSearchs(searchModel.getSearchs().stream()
				.map(external->toInternalSearchModel(external, clazz)).collect(Collectors.toList()));
		return internalModel;
	}
}
