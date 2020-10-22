package com.example.spring5webApp.repositories;

import com.example.spring5webApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
