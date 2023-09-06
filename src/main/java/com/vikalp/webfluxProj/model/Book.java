package com.vikalp.webfluxProj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Document(value = "Book")
public class Book {
    @Id
    @NotNull
    @NotBlank
    private int id;
    @NotNull
    @NotBlank
    private int copiesAvailable;
    @NotNull
    @NotBlank
    private int authorId;
    @NotNull
    @NotBlank
    private String genre;

    public Book(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Book(int id, int copiesAvailable, int authorId, String genre) {
        this.id = id;
        this.copiesAvailable = copiesAvailable;
        this.authorId = authorId;
        this.genre = genre;
    }


}

