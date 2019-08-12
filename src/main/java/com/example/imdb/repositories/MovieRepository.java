package com.example.imdb.repositories;

import com.example.imdb.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    /**
     * This method will find an Movie instance in the database by its created date.
     * Note that this method is not implemented and its working code will be
     * automatically generated from its signature by Spring Data JPA.
     */
//    public Movie findByCreated_date(Date created_date);
    public Movie findBy_id(ObjectId _id);

}