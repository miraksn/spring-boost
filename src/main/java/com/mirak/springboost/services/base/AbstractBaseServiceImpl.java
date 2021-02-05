package com.mirak.springboost.services.base;

import java.util.Collection;

import org.springframework.data.jpa.domain.Specification;

import com.mirak.springboost.annotations.searchable.models.SearchResponse;
import com.mirak.springboost.annotations.searchable.processors.SearchableEntityProcessor;
import com.mirak.springboost.annotations.searchable.processors.SearchableProcessor;
import com.mirak.springboost.repositories.BaseRepository;
import com.mirak.springboost.services.BaseService;
import com.mirak.springboost.specifications.models.SearchData;
import com.mirak.springboost.specifications.models.SearchModel;

/**
 * 
 * @author karim SNOUSSI
 *
 *         CRUD Service ready to extend
 *
 * @param <T>
 */
public abstract class AbstractBaseServiceImpl<T> implements BaseService<T> {

	protected Class<T> entityClass;

	protected BaseRepository<T> repository;

	public AbstractBaseServiceImpl(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

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
	public SearchResponse<T> search(SearchData searchData) {
		try {
			if (SearchableEntityProcessor.isSearchableEntity(entityClass.getClass())) {
				SearchModel searchModel = SearchableProcessor.toInternalSearchModel(searchData.getSearchData(),
						entityClass);
				Specification<T> spec = searchModel.buildSpecification();
				searchModel.buildSpecification();
				SearchResponse<T> searchResult = new SearchResponse<T>(repository.findAll(spec, getPageable(
						searchData.getPage(), searchData.getSize(), searchData.getSort(), searchData.getOrder())));
				return searchResult;
			} else {
				return new SearchResponse<T>();
			}
		} catch (Exception e) {
			return new SearchResponse<T>();
		}
	}

}
