package com.mirak.springboost.annotations.searchable.processors;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.mirak.springboost.annotations.searchable.Searchable;
import com.mirak.springboost.annotations.searchable.enums.Type;
import com.mirak.springboost.annotations.searchable.models.SearchableDetails;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public final class SearchableProcessor {

	private static final Map<Class<?>, Map<String, SearchableDetails>> searchableDetailsMap = new HashMap<>();

	public static SearchableDetails getSearchableDetailsByTagName(Class<?> clazz, String targetName) {
		Map<String, SearchableDetails> searchMap = getSearchableMap(clazz);
		if (searchMap != null) {
			return searchMap.get(targetName);
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
							getSearchableTagName(fields[i]), getSearchableType(fields[i])));
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
}
