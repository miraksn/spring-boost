package com.mirak.springboost.specifications.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import com.mirak.springboost.specifications.DefaultSpecification;
import com.mirak.springboost.specifications.enums.SearchOperation;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public class SearchModel {
	private Map<String, SearchDetails> search = new HashMap<String, SearchDetails>();
	private List<SearchModel> searchs = new ArrayList<>();
	private SearchOperation operation = SearchOperation.AND;

	public SearchModel() {
	}

	public SearchModel(SearchOperation operation) {
		this.operation = operation;
	}

	public SearchModel(Map<String, SearchDetails> search, List<SearchModel> searchs, SearchOperation operation) {
		this.search = search;
		this.searchs = searchs;
		this.operation = operation;
	}

	/**
	 * @return the search
	 */
	public Map<String, SearchDetails> getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(Map<String, SearchDetails> search) {
		this.search = search;
	}

	/**
	 * @return the searchs
	 */
	public List<SearchModel> getSearchs() {
		return searchs;
	}

	/**
	 * @param searchs the searchs to set
	 */
	public void setSearchs(List<SearchModel> searchs) {
		this.searchs = searchs;
	}

	/**
	 * @return the operation
	 */
	public SearchOperation getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(SearchOperation operation) {
		this.operation = operation;
	}

	public <E> Specification<E> buildSpecification() {
		Specification<E> spec = null;
		if (!search.isEmpty()) {
			List<String> attributes = new ArrayList<String>(search.keySet());
			List<SearchCriteria> criterias = new ArrayList<SearchCriteria>();
			attributes.forEach(attribute->{
				criterias.addAll(search
					.get(attribute)
					.toSearchCriterias(attribute));
			});
			spec = SearchModel.buildAndSpecification(criterias);
		}
		
		if (searchs != null && !searchs.isEmpty()) {
			switch (operation) {
			case AND:
				for (Iterator<SearchModel> iterator = searchs.iterator(); iterator.hasNext();) {
					SearchModel searchModel = (SearchModel) iterator.next();
					if (spec == null) {
						spec = searchModel.buildSpecification();
					} else {
						spec = spec.and(searchModel.buildSpecification());
					}
				}
				break;
			case OR:
				for (Iterator<SearchModel> iterator = searchs.iterator(); iterator.hasNext();) {
					SearchModel searchModel = (SearchModel) iterator.next();
					if (spec == null) {
						spec = searchModel.buildSpecification();
					} else {
						spec = spec.or(searchModel.buildSpecification());
					}
				}
				break;
			default:
				break;
			}
		}
		return spec;
	}
	
	private static <E> Specification<E> buildAndSpecification(List<SearchCriteria> criterias) {
		if (criterias.isEmpty()) {
			return null;
		}
		Specification<E> spec = null;
		for (Iterator<SearchCriteria> iterator = criterias.iterator(); iterator.hasNext();) {
			SearchCriteria criteria = (SearchCriteria) iterator.next();
			if (spec == null) {
				spec = new DefaultSpecification<E>(criteria);
			} else {
				spec = spec.and(new DefaultSpecification<E>(criteria));
			}
		}
		return spec;
	}

}
