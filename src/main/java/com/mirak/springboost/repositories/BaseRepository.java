package com.mirak.springboost.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author karim SNOUSSI
 *
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long>{
	Optional<T> findByUuid(String uuid);
	void deleteByUuid(String uuid);
}
