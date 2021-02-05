package com.mirak.springboost.annotations.map;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.mirak.springboost.entities.BaseEntity;

/**
 * 
 * @author karim SNOUSSI
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface EntityMapping {
	Class<? extends BaseEntity> model();
}
