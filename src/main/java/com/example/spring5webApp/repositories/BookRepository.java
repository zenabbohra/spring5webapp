package com.example.spring5webApp.repositories;

import com.example.spring5webApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
