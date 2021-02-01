package com.mirak.springboost.annotations.searchable.models;

import com.mirak.springboost.annotations.searchable.enums.Type;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public final class SearchableDetails {

	private String name;
	private String targetName;
	private Type type;

	/**
	 * @param name
	 * @param targetName
	 * @param type
	 * @param value
	 */
	public SearchableDetails(String name, String targetName, Type type) {
		this.name = name;
		this.targetName = targetName;
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the targetName
	 */
	public String getTargetName() {
		return targetName;
	}

	/**
	 * @param targetName the targetName to set
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

}
