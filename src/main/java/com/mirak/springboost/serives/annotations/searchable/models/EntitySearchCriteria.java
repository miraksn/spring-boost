package com.mirak.springboost.serives.annotations.searchable.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public class EntitySearchCriteria<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int page;
    private int size;
    private String sort;
    private String order;

    private Map<String, T> searchMinValues = new HashMap<>();
    private Map<String, T> searchEqualsValues = new HashMap<>();
    private Map<String, T> searchMaxValues = new HashMap<>();

    public EntitySearchCriteria() {
        this.size = 10;
        this.page = 0;
    }
    
	public EntitySearchCriteria(Integer page, Integer size, String sort, String order) {
		super();
		this.page = page != null ? page : 0;
		this.size = ((size != null) && (size > 0)) ? size : 10;
		this.sort = sort != null && !sort.isEmpty() ? sort : null;
		this.order = order != null && !order.isEmpty() ? order : null;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the searchMinValues
	 */
	public Map<String, T> getSearchMinValues() {
		return searchMinValues;
	}

	/**
	 * @param searchMinValues the searchMinValues to set
	 */
	public void setSearchMinValues(Map<String, T> searchMinValues) {
		this.searchMinValues = searchMinValues;
	}

	/**
	 * @return the searchEqualsValues
	 */
	public Map<String, T> getSearchEqualsValues() {
		return searchEqualsValues;
	}

	/**
	 * @param searchEqualsValues the searchEqualsValues to set
	 */
	public void setSearchEqualsValues(Map<String, T> searchEqualsValues) {
		this.searchEqualsValues = searchEqualsValues;
	}

	/**
	 * @return the searchMaxValues
	 */
	public Map<String, T> getSearchMaxValues() {
		return searchMaxValues;
	}

	/**
	 * @param searchMaxValues the searchMaxValues to set
	 */
	public void setSearchMaxValues(Map<String, T> searchMaxValues) {
		this.searchMaxValues = searchMaxValues;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
