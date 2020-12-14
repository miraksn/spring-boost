package com.mirak.springboost.services;

import java.util.Collection;

import com.mirak.springboost.serives.annotations.searchable.models.EntitySearchCriteria;
import com.mirak.springboost.serives.annotations.searchable.models.SearchResponse;

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
	default SearchResponse<T> search(EntitySearchCriteria<T> criteria) {
		return new SearchResponse<T>();
	};
}
