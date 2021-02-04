package com.mirak.springboost.services;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
	default Pageable getPageable(Integer page, Integer size, String sortAttribute, String sortDirection) {
		Sort sort = null;
		if (size == null) {
			size = 10;
		}
        if (sortAttribute != null) {
            sort = Sort.by(sortAttribute);
            if (sortDirection != null && sortDirection.toLowerCase().equals("desc")) {
                sort = sort.descending();
            } else {
                sort = sort.ascending();
            }
        }
        Pageable pageable = null;
        if (sort != null) {
            pageable = PageRequest.of(page >= 1 ? page - 1 : 0,
            		size > 0 ? size : 12, sort);
        } else {
            pageable = PageRequest.of(page >= 1 ? page - 1 : 0,
            		size > 0 ? size : 12);
        }
        return pageable;
	}
}
