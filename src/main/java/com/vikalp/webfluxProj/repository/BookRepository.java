package com.vikalp.webfluxProj.repository;

import com.vikalp.webfluxProj.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;
@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {

    Flux<Book> findByGenre(String text);

    Flux<Book> findByGenreAndCopiesAvailableGreaterThan(String genre, int copies);

    Flux<Book> findByAuthorId(int id);

}
