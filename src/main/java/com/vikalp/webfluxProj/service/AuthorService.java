package com.vikalp.webfluxProj.service;

import com.vikalp.webfluxProj.model.Author;
import com.vikalp.webfluxProj.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Mono<Author> getBooksByAuthor(String text)
    {
        return authorRepository.findByName(text);
    }

    public Mono<Author> addAuthor(Author author){
        return authorRepository.save(author);
    }

    public Flux<Author> getByRegex(String text) {return authorRepository.findByNameRegex(text);}

}

