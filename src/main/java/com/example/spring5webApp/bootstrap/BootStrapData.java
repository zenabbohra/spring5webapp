package com.example.spring5webApp.bootstrap;

import com.example.spring5webApp.domain.Author;
import com.example.spring5webApp.domain.Book;
import com.example.spring5webApp.domain.Publisher;
import com.example.spring5webApp.repositories.AuthorRepository;
import com.example.spring5webApp.repositories.BookRepository;
import com.example.spring5webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository,
      BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override public void run(String... args) throws Exception {
    Publisher publisher = new Publisher();
    publisher.setName("SFG Publishing");
    publisher.setCity("St Petersburg");
    publisher.setState("FL");

    publisherRepository.save(publisher);


    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123456");

    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    ddd.setPublisher(publisher);
    publisher.getBooks().add(ddd);

    authorRepository.save(eric);
    bookRepository.save(ddd);
    publisherRepository.save(publisher);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "2345356");

    noEJB.setPublisher(publisher);
    publisher.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publisherRepository.save(publisher);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of books: " + bookRepository.count());
    System.out.println("Number of publishers: " + publisherRepository.count());
    System.out.println("Publisher Number of books: " + publisher.getBooks().size());
  }
}
