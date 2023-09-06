package com.vikalp.webfluxProj.service;

import com.vikalp.webfluxProj.model.Book;
import com.vikalp.webfluxProj.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Mono<Book> addBook(Book book){
        return bookRepository.save(book);
    }

    public Flux<Book> getByGenre(String genre){ return bookRepository.findByGenre(genre);}

    public Flux<Book> getByGenreAndCopies(String genre, int copies){
        return bookRepository.findByGenreAndCopiesAvailableGreaterThan(genre, copies);
    }

    public Flux<Book> getByAuthorId(int id){
        return bookRepository.findByAuthorId(id);
    }


}
