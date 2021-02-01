package com.mirak.springboost.services.base;

import java.util.Collection;

import com.mirak.springboost.repositories.BaseRepository;
import com.mirak.springboost.annotations.searchable.models.EntitySearchCriteria;
import com.mirak.springboost.annotations.searchable.models.SearchResponse;
import com.mirak.springboost.annotations.searchable.processors.SearchableEntityProcessor;
import com.mirak.springboost.services.BaseService;

/**
 * 
 * @author karim SNOUSSI
 *
 * CRUD Service ready to extend
 *
 * @param <T>
 */
public abstract class AbstractBaseServiceImpl<T> implements BaseService<T> {

	protected BaseRepository<T> repository;
	
	private T typeTool;
	
	@Override
	public T findByUuid(String uuid) {
		return repository.findByUuid(uuid).orElse(null);
	}

	@Override
	public T findById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public Collection<T> findAll() {
		return repository.findAll();
	}

	@Override
	public T save(T entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public Collection<T> save(Collection<T> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public void remove(T entity) {
		repository.delete(entity);
	}

	@Override
	public void removeByUuid(String uuid) {
		repository.deleteByUuid(uuid);
	}

	@Override
	public void removeById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void removeAll(Collection<T> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public SearchResponse<T> search(EntitySearchCriteria<T> criteria) {
		try {
			if (SearchableEntityProcessor.isSearchableEntity(typeTool.getClass())) {
				
				
				// TODO: do search
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	
		return new SearchResponse<T>();
	}
	
}
