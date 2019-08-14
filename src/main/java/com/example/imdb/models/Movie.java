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

/**
 * The type Movie.
 */
@Document(collection = "movies")
@TypeAlias("movie")
public class Movie extends Base {

    @NotNull
    @Size(min=1)
    @Indexed(unique = true)
    private String name;

    @NotNull
    @Size(min=1)
    private List<String> genres;

    @NotNull
    @Size(min=1)
    private String director;

    @NotNull
    @Indexed
    private int year;

    @NotNull
    @Indexed
    private List<String> music;

    @NotNull
    @Indexed
    private List<String> producer;

    @TextIndexed
    private String description;

    @NotNull
    private List<String> writers;

    @NotNull
    private List<String> stars;

    @NotNull
    private List<String> casting;

    private String reviews;

    private double rating;


    /**
     * Gets producer.
     *
     * @return the producer
     */
    public List<String> getProducer() {
        return producer;
    }

    /**
     * Sets producer.
     *
     * @param producer the producer
     */
    public void setProducer(List<String> producer) {
        this.producer = producer;
    }

    /**
     * Gets casting.
     *
     * @return the casting
     */
    public List<String> getCasting() {
        return casting;
    }

    /**
     * Sets casting.
     *
     * @param casting the casting
     */
    public void setCasting(List<String> casting) {
        this.casting = casting;
    }


    /**
     * Sets cast.
     *
     * @param stars the stars
     */
    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    /**
     * Gets cast.
     *
     * @return the cast
     */
    public List<String> getStars() {
        return stars;
    }

    /**
     * Gets review.
     *
     * @return the review
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * Sets review.
     *
     * @param review the review
     */
    public void setReviews(String review) {
        this.reviews = review;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets writers.
     *
     * @return the writers
     */
    public List<String> getWriters() {
        return writers;
    }

    /**
     * Sets writers.
     *
     * @param writers the writers
     */
    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets genres.
     *
     * @return the genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * Sets genre.
     *
     * @param genres the genre
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /**
     * Gets director.
     *
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets director.
     *
     * @param director the director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }


    /**
     * Gets music by.
     *
     * @return the music by
     */
    public List<String> getMusic() {
        return music;
    }

    /**
     * Sets music by.
     *
     * @param music the music by
     */
    public void setMusic(List<String> music) {
        this.music = music;
    }

}