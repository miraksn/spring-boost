package com.mirak.springboost.specifications.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.mirak.springboost.specifications.enums.Operation;
import com.mirak.springboost.specifications.enums.Operator;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public class SearchDetails {
	private Comparable<? extends Object> minValue;
	private Comparable<? extends Object> minValueOrEqual;

	private Comparable<? extends Object> equalValue;

	private Comparable<? extends Object> maxValue;
	private Comparable<? extends Object> maxValueOrEqual;

	private String lessThanOrEqualTo;
	private String lessThan;

	private String equalTo;

	private String moreThan;
	private String moreThanOrEqualTo;

	private String likeValue;
	private String like;

	private Comparable<? extends Object> containsValue;
	private String contains;

	private List<String> in = new ArrayList<String>();
	private List<Comparable<? extends Object>> inValues = new ArrayList<Comparable<? extends Object>>();

	public SearchDetails() {
	}
	
	/**
	 * @return the minValue
	 */
	public Comparable<? extends Object> getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(Comparable<? extends Object> minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the minValueOrEqual
	 */
	public Comparable<? extends Object> getMinValueOrEqual() {
		return minValueOrEqual;
	}

	/**
	 * @param minValueOrEqual the minValueOrEqual to set
	 */
	public void setMinValueOrEqual(Comparable<? extends Object> minValueOrEqual) {
		this.minValueOrEqual = minValueOrEqual;
	}

	/**
	 * @return the equalValue
	 */
	public Comparable<? extends Object> getEqualValue() {
		return equalValue;
	}

	/**
	 * @param equalValue the equalValue to set
	 */
	public void setEqualValue(Comparable<? extends Object> equalValue) {
		this.equalValue = equalValue;
	}

	/**
	 * @return the maxValue
	 */
	public Comparable<? extends Object> getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(Comparable<? extends Object> maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the maxValueOrEqual
	 */
	public Comparable<? extends Object> getMaxValueOrEqual() {
		return maxValueOrEqual;
	}

	/**
	 * @param maxValueOrEqual the maxValueOrEqual to set
	 */
	public void setMaxValueOrEqual(Comparable<? extends Object> maxValueOrEqual) {
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
	public Comparable<? extends Object> getContainsValue() {
		return containsValue;
	}

	/**
	 * @param containsValue the containsValue to set
	 */
	public void setContainsValue(Comparable<? extends Object> containsValue) {
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
	public List<Comparable<? extends Object>> getInValues() {
		return inValues;
	}

	/**
	 * @param inValues the inValues to set
	 */
	public void setInValues(List<Comparable<? extends Object>> inValues) {
		this.inValues = inValues;
	}

	public List<SearchCriteria> toSearchCriterias(String attributeName) {
		Assert.notNull(attributeName,"THE ATTRIBUTE NAME CAN NOT BE NULL");
		Assert.isTrue(!attributeName.isEmpty(),"THE ATTRIBUTE NAME CAN NOT BE EMPTY");
		List<SearchCriteria> criterias = new ArrayList<SearchCriteria>();
		

		if(minValue!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_VALUE,
					Operator.MORE_THAN, attributeName, minValue));
		}
		
		if(minValueOrEqual!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_VALUE,
					Operator.EQUALS_OR_MORE_THAN, attributeName, minValueOrEqual));
		}
		
		if(equalValue!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_VALUE,
					Operator.EQUALS, attributeName, equalValue));
		}
		
		if(maxValue!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_VALUE,
					Operator.LESS_THAN, attributeName, maxValue));
		}
		
		if(maxValueOrEqual!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_VALUE,
					Operator.EQUALS_OR_LESS_THAN, attributeName, maxValueOrEqual));
		}
		
		if(lessThanOrEqualTo!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_COLUMN,
					Operator.EQUALS_OR_LESS_THAN, attributeName, lessThanOrEqualTo));
		}
		
		if(lessThan!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_COLUMN,
					Operator.LESS_THAN, attributeName, lessThan));
		}
		
		if(equalTo!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_COLUMN,
					Operator.EQUALS, attributeName, equalTo));
		}
		
		if(moreThan!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_COLUMN,
					Operator.MORE_THAN, attributeName, moreThan));
		}
		
		if(moreThanOrEqualTo!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_COLUMN,
					Operator.EQUALS_OR_MORE_THAN, attributeName, moreThanOrEqualTo));
		}
		
		if(likeValue!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_VALUE,
					Operator.LIKE, attributeName, likeValue));
		}
		
		if(like!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_COLUMN,
					Operator.MORE_THAN, attributeName, like));
		}
		
		if(containsValue!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_VALUE,
					Operator.CONTAINS, attributeName, containsValue));
		}
		
		if(contains!=null) {
			criterias.add(new SearchCriteria(Operation.COLUMN_TO_COLUMN,
					Operator.CONTAINS, attributeName, contains));
		}
		
		return criterias;
	}

}
