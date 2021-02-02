package com.mirak.springboost.specifications.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mirak.springboost.specifications.enums.SearchOperation;

public class SearchModel {
	private Map<String, SearchDetails> Search = new HashMap<String, SearchDetails>();
	private List<SearchModel> Searchs = new ArrayList<>();
	private SearchOperation operation = SearchOperation.AND;

	/**
	 * @return the search
	 */
	public Map<String, SearchDetails> getSearch() {
		return Search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(Map<String, SearchDetails> search) {
		Search = search;
	}

	/**
	 * @return the searchs
	 */
	public List<SearchModel> getSearchs() {
		return Searchs;
	}

	/**
	 * @param searchs the searchs to set
	 */
	public void setSearchs(List<SearchModel> searchs) {
		Searchs = searchs;
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

}
