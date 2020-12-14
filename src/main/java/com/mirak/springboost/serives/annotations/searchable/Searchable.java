package com.mirak.springboost.serives.annotations.searchable;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.mirak.springboost.serives.annotations.searchable.enums.Type;

/**
 * 
 * @author karim SNOUSSI
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Searchable {
	Type type();
	String target();
}
