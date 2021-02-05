package com.mirak.springboost.endpoints.base;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mirak.springboost.annotations.searchable.models.SearchResponse;
import com.mirak.springboost.entities.BaseEntity;

/**
 * 
 * @author karim SNOUSSI
 *
 */
public interface BaseEndpoint<T extends BaseEntity> {
    @PostMapping
    ResponseEntity<T> save(@Valid @RequestBody T input);

    @PutMapping
    ResponseEntity<T> update(@Valid @RequestBody T input);

    @PatchMapping
    ResponseEntity<T> patch(@Valid @RequestBody T input);

    @DeleteMapping("{uuid}")
    ResponseEntity<T> deleteById(@Valid @NotNull @PathVariable(name = "uuid") String uuid);

    @GetMapping
    ResponseEntity<Collection<T>> getAll();

    @PostMapping("search")
    ResponseEntity<SearchResponse<T>> search(@Valid @RequestBody T input);

    @GetMapping("{uuid}")
    ResponseEntity<T> getById(@Valid @NotNull @PathVariable(name = "uuid") String uuid);
}
