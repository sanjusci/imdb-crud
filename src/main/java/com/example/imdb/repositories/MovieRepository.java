/**
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

package com.example.imdb.repositories;

import com.example.imdb.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Movie repository.
 */
@Transactional
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    /**
     * This method will find an Movie instance in the database by its created date.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     *
     * @param _id the id
     * @return the movie
     */
    public Movie findBy_id(ObjectId _id);

}