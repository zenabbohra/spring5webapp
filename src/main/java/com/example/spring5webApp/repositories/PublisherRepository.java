package com.example.spring5webApp.repositories;

import com.example.spring5webApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
