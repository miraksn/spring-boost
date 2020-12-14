package com.mirak.springboost.serives.annotations.searchable;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author karim SNOUSSI
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface SearchableEntity {
	int getDepth();
}
