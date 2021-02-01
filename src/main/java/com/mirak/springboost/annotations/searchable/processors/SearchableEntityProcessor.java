package com.mirak.springboost.annotations.searchable.processors;

import com.mirak.springboost.annotations.searchable.SearchableEntity;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public final class SearchableEntityProcessor {

	public static boolean isSearchableEntity(Class<?> clazz) {
		if (clazz == null) {
			return false;
		}
		return clazz.isAnnotationPresent(SearchableEntity.class);
	}


	public static boolean isSearchableEntity(Object o) {
		if (o == null) {
			return false;
		}
		return isSearchableEntity(o.getClass());
	}
}
