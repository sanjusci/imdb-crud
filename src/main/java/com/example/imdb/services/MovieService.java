package com.example.imdb.services;

import com.example.imdb.models.Movie;
import com.example.imdb.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class MovieService extends BaseService {

    @Autowired
    private MovieRepository movieRepository;

    public Map<String, Object> create(Movie movie) {
        movie.set_id(ObjectId.get());
        movie.setCreated_date(new Date());
        return getStringObjectMap(movie, "Movie created successfully");
    }

    /**
     * GET /read  --> Read a movie by movie id from the database.
     */
    public Map<String, Object> read(ObjectId id) {
        Movie movie = movieRepository.findBy_id(id);
//        List movie = java.util.Arrays.asList(movieService.findBy_id(id));
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Movie found successfully");
        dataMap.put("totalMovie", 1);
        dataMap.put("status", HttpStatus.ACCEPTED);
        dataMap.put("movies", movie);
        return dataMap;
    }

    /**
     * GET /update  --> Update a movie record and save it in the database.
     */
    public Map<String, Object> update(ObjectId id, Movie movie) {
        movie.set_id(id);
        movie.setUpdated_date(new Date());
        return getStringObjectMap(movie, "Movie updated successfully");
    }

    /**
     * GET /delete  --> Delete a movie from the database.
     */
    public Map<String, Object> delete(ObjectId id) {
        movieRepository.delete(movieRepository.findBy_id(id));
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Movie deleted successfully");
        dataMap.put("status", HttpStatus.ACCEPTED);
        return dataMap;
    }

    /**
     * GET /read  --> Read all movie from the database.
     */
    public Map<String, Object> fetchAll() {
        List movies =  movieRepository.findAll();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Movie found successfully");
        dataMap.put("totalMovie", movies.size());
        dataMap.put("status", HttpStatus.ACCEPTED);
        dataMap.put("movies", movies);
        return dataMap;
    }
    /**
     *
     * @param movie
     * @param s
     * @return
     */
    private Map<String, Object> getStringObjectMap(@RequestBody @Valid Movie movie, String s) {
        movieRepository.save(movie);
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", s);
        dataMap.put("status", HttpStatus.ACCEPTED);
        dataMap.put("movie", movie);
        return dataMap;
    }
}