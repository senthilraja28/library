package com.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.jpa.BookJpa;

public interface BookRepository extends CrudRepository<BookJpa, Long>{

}
