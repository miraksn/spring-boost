package com.mirak.springboost.endpoints.models;

import com.mirak.springboost.entities.BaseEntity;

public interface EntityEndpointModel<T extends BaseEntity> {
	
	/**
	 * Convert a EntityEndpointModel<T> object to T object
	 * @param model
	 * @return
	 */
	T toInternalEntity(EntityEndpointModel<T> model);
	
	/**
	 * Convert a T object to EntityEndpointModel<T> object
	 * @param T entity
	 * @return {@link EntityEndpointModel<T>}
	 */
	EntityEndpointModel<T> toEntityEndpointModel(T entity);
}
