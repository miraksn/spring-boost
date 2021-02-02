package com.mirak.springboost.specifications.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public class SearchDetails {
	private Object minValue;
	private Object minValueOrEqual;

	private Object equalValue;

	private Object maxValue;
	private Object maxValueOrEqual;

	private String lessThanOrEqualTo;
	private String lessThan;

	private String equalTo;

	private String moreThan;
	private String moreThanOrEqualTo;

	private String likeValue;
	private String like;

	private Object containsValue;
	private String contains;

	private List<String> in = new ArrayList<String>();
	private List<Object> inValues = new ArrayList<Object>();

	public SearchDetails() {
	}

	/**
	 * @return the minValue
	 */
	public Object getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(Object minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the minValueOrEqual
	 */
	public Object getMinValueOrEqual() {
		return minValueOrEqual;
	}

	/**
	 * @param minValueOrEqual the minValueOrEqual to set
	 */
	public void setMinValueOrEqual(Object minValueOrEqual) {
		this.minValueOrEqual = minValueOrEqual;
	}

	/**
	 * @return the equalValue
	 */
	public Object getEqualValue() {
		return equalValue;
	}

	/**
	 * @param equalValue the equalValue to set
	 */
	public void setEqualValue(Object equalValue) {
		this.equalValue = equalValue;
	}

	/**
	 * @return the maxValue
	 */
	public Object getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(Object maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the maxValueOrEqual
	 */
	public Object getMaxValueOrEqual() {
		return maxValueOrEqual;
	}

	/**
	 * @param maxValueOrEqual the maxValueOrEqual to set
	 */
	public void setMaxValueOrEqual(Object maxValueOrEqual) {
		this.maxValueOrEqual = maxValueOrEqual;
	}

	/**
	 * @return the lessThanOrEqualTo
	 */
	public String getLessThanOrEqualTo() {
		return lessThanOrEqualTo;
	}

	/**
	 * @param lessThanOrEqualTo the lessThanOrEqualTo to set
	 */
	public void setLessThanOrEqualTo(String lessThanOrEqualTo) {
		this.lessThanOrEqualTo = lessThanOrEqualTo;
	}

	/**
	 * @return the lessThan
	 */
	public String getLessThan() {
		return lessThan;
	}

	/**
	 * @param lessThan the lessThan to set
	 */
	public void setLessThan(String lessThan) {
		this.lessThan = lessThan;
	}

	/**
	 * @return the equalTo
	 */
	public String getEqualTo() {
		return equalTo;
	}

	/**
	 * @param equalTo the equalTo to set
	 */
	public void setEqualTo(String equalTo) {
		this.equalTo = equalTo;
	}

	/**
	 * @return the moreThan
	 */
	public String getMoreThan() {
		return moreThan;
	}

	/**
	 * @param moreThan the moreThan to set
	 */
	public void setMoreThan(String moreThan) {
		this.moreThan = moreThan;
	}

	/**
	 * @return the moreThanOrEqualTo
	 */
	public String getMoreThanOrEqualTo() {
		return moreThanOrEqualTo;
	}

	/**
	 * @param moreThanOrEqualTo the moreThanOrEqualTo to set
	 */
	public void setMoreThanOrEqualTo(String moreThanOrEqualTo) {
		this.moreThanOrEqualTo = moreThanOrEqualTo;
	}

	/**
	 * @return the likeValue
	 */
	public String getLikeValue() {
		return likeValue;
	}

	/**
	 * @param likeValue the likeValue to set
	 */
	public void setLikeValue(String likeValue) {
		this.likeValue = likeValue;
	}

	/**
	 * @return the like
	 */
	public String getLike() {
		return like;
	}

	/**
	 * @param like the like to set
	 */
	public void setLike(String like) {
		this.like = like;
	}

	/**
	 * @return the containsValue
	 */
	public Object getContainsValue() {
		return containsValue;
	}

	/**
	 * @param containsValue the containsValue to set
	 */
	public void setContainsValue(Object containsValue) {
		this.containsValue = containsValue;
	}

	/**
	 * @return the contains
	 */
	public String getContains() {
		return contains;
	}

	/**
	 * @param contains the contains to set
	 */
	public void setContains(String contains) {
		this.contains = contains;
	}

	/**
	 * @return the in
	 */
	public List<String> getIn() {
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(List<String> in) {
		this.in = in;
	}

	/**
	 * @return the inValues
	 */
	public List<Object> getInValues() {
		return inValues;
	}

	/**
	 * @param inValues the inValues to set
	 */
	public void setInValues(List<Object> inValues) {
		this.inValues = inValues;
	}

}
