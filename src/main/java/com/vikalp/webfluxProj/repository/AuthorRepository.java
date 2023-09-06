package com.vikalp.webfluxProj.repository;

import com.vikalp.webfluxProj.model.Author;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<Author,Integer> {

    Mono<Author> findByName(String text);
    Flux<Author> findByNameRegex(String text);

}
