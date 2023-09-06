package com.vikalp.webfluxProj.controller;

import com.vikalp.webfluxProj.model.Author;
import com.vikalp.webfluxProj.model.Book;
import com.vikalp.webfluxProj.service.AuthorService;
import com.vikalp.webfluxProj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FluxAndMonoController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    @CrossOrigin
    public Flux<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getGenre")
    @CrossOrigin
    public Flux<Book> search(@RequestParam String genre) {
        return bookService.getByGenre(genre);
    }

    @GetMapping("/getGenreAndCount")
    @CrossOrigin
    public Flux<Book> genreAndCount(@RequestParam String genre, @RequestParam int copies)
    {
        return bookService.getByGenreAndCopies(genre,copies);
    }

    @PostMapping("/addBook")
    @CrossOrigin
    public Mono<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PostMapping("/addAuthor")
    @CrossOrigin
    public Mono<Author> addBook(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @GetMapping("/getBooksByAuthor")
    @CrossOrigin
    public Flux<Book> getBooksByAuthor(@RequestParam String text){
        return authorService.getBooksByAuthor(text).flatMapMany(author -> bookService.getByAuthorId(author.getId()));
    }

    @GetMapping("/regex")
    @CrossOrigin
    public Flux<Author> getByRegex(@RequestParam String text){
        return authorService.getByRegex(text);
    }

}
