package com.alpha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alpha.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
