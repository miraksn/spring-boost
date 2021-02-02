package com.mirak.springboost.services;

import java.util.Collection;

import com.mirak.springboost.annotations.searchable.models.SearchResponse;
import com.mirak.springboost.specifications.models.SearchData;

/**
 * 
 * @author karim SNOUSSI
 *
 * CRUD interface ready to implement
 *
 * @param <T>
 */
public interface BaseService<T> {
	T findByUuid(String uuid);
	T findById(Long id);
	Collection<T> findAll();
	T save(T entity);
	Collection<T> save(Collection<T> entities);
	T update(T entity);
	void remove(T entity);
	void removeByUuid(String uuid);
	void removeById(Long id);
	void removeAll(Collection<T> entities);
	default SearchResponse<T> search(SearchData searchData) {
		return new SearchResponse<T>();
	}
}
