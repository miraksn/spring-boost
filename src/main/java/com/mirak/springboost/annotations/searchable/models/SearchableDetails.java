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
	private Class<?> attributeClass;

	/**
	 * @param name
	 * @param targetName
	 * @param type
	 * @param attributeClass
	 */
	public SearchableDetails(String name, String targetName, Type type, Class<?> attributeClass) {
		this.name = name;
		this.targetName = targetName;
		this.type = type;
		this.attributeClass = attributeClass;
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

	/**
	 * @return the attributeClass
	 */
	public Class<?> getAttributeClass() {
		return attributeClass;
	}

	/**
	 * @param attributeClass the attributeClass to set
	 */
	public void setAttributeClass(Class<?> attributeClass) {
		this.attributeClass = attributeClass;
	}
	
	@Override
	public SearchableDetails clone() {
		return new SearchableDetails(name, targetName, type, attributeClass);
	}
}
