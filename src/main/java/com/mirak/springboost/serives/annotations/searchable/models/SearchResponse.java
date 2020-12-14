package com.mirak.springboost.serives.annotations.searchable.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public class SearchResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> searchResult = new ArrayList<>();
	private long currentPage;
	private long totalPages;
	private long totalElements;

	public SearchResponse() {
		super();
	}

	public SearchResponse(Page<T> page) {
		this.searchResult = page.getContent();
		this.currentPage = page.getNumber();
		this.totalPages = page.getTotalPages();
		this.totalPages = page.getTotalElements();
	}

	/**
	 * @return the searchResult
	 */
	public List<T> getSearchResult() {
		return searchResult;
	}

	/**
	 * @param searchResult the searchResult to set
	 */
	public void setSearchResult(List<T> searchResult) {
		this.searchResult = searchResult;
	}

	/**
	 * @return the currentPage
	 */
	public long getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the totalPages
	 */
	public long getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the totalElements
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
