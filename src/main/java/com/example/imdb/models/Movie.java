/**
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

package com.example.imdb.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "movies")
public class Movie extends Base {

    @NotNull
    @Size(min=1)
    private String name;

    @NotNull
    @Size(min=1)
    private String genre;

    @NotNull
    @Size(min=1)
    private String director;

    private int year;

    private String description;

    private String writers;

    private String reviews;

    private double rating;

    private String cast;

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCast() {
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

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
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