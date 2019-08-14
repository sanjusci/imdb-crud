/**
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

package com.example.imdb.models;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Document(collection = "movies")
@TypeAlias("movie")
public class Movie extends Base {

    @NotNull
    @Size(min=1)
    @Indexed
    private String name;

    @NotNull
    @Size(min=1)
    private String genre;

    @NotNull
    @Size(min=1)
    private String director;

    @NotNull
    @Indexed
    private int year;

    @TextIndexed
    private String description;

    @NotNull
    private List<String> writers;
    private List<String> cast;

    private String reviews;

    private double rating;

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getCast() {
        return cast;
    }

    public String getReview() {
        return reviews;
    }

    public void setReview(String review) {
        this.reviews = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}