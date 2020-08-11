package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.library.jpa.LibraryJpa;


public interface LibraryRepository extends CrudRepository<LibraryJpa, Long>{

	
}
