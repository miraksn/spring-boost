package com.mirak.springboost.annotations.map;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.mirak.springboost.endpoints.models.EntityEndpointModel;

/**
 * 
 * @author karim SNOUSSI
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface EntityAttributMapping {
	String moedelAttributName();
	@SuppressWarnings("rawtypes")
	Class<? extends EntityEndpointModel> moedelAttributClass() default EntityEndpointModel.class;
}
