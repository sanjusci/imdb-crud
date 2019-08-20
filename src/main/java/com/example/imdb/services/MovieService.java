/**
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

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


/**
 * The type Movie service.
 */
@Service
@Transactional
public class MovieService extends BaseService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Create map.
     *
     * @param movie the movie
     * @return the map
     */
    public Map<String, Object> create(@RequestBody @Valid Movie movie) {
        movie.set_id(ObjectId.get());
        movie.setCreated_date(new Date());
        movieRepository.save(movie);
        return getStringObjectMap(movie, "Movie created successfully", 0, HttpStatus.CREATED);
    }

    /**
     * GET /read  --> Read a movie by movie id from the database.
     *
     * @param id the id
     * @return the map
     */
    public Map<String, Object> read(ObjectId id) {
        Movie movie = movieRepository.findBy_id(id);
//        List movie = java.util.Arrays.asList(movieService.findBy_id(id));
        String msg = movie == null ? "Movie not found" : "Movie fetch successfully";
        return getStringObjectMap(movie, msg, movie == null ? 0 : 1, HttpStatus.OK);
    }

    /**
     * GET /update  --> Update a movie record and save it in the database.
     *
     * @param id    the id
     * @param movie the movie
     * @return the map
     */
    public Map<String, Object> update(ObjectId id, @RequestBody @Valid Movie movie) {
        movie.set_id(id);
        movie.setUpdated_date(new Date());
        movieRepository.save(movie);
        return getStringObjectMap(movie, "Movie updated successfully",0, HttpStatus.OK);
    }

    /**
     * Patch map.
     *
     * @param id the id
     * @return the map
     */
    public Map<String, Object> patch(ObjectId id) {
        Movie movie = movieRepository.findBy_id(id);
        String msg;
        HttpStatus status;
        if (movie != null) {
            movie.setIs_active(movie.getIs_active().equals("no") ? "yes" : "no");
            movieRepository.save(movie);
            msg = movie.getIs_active().equals("yes") ?  "Movie activated successfully" : "Movie deactivated successfully";
            status = HttpStatus.OK;
        } else {
            msg = "Movie not found";
            status = HttpStatus.NOT_FOUND;
        }
        return getStringObjectMap(null, msg, 0, status);
    }

    /**
     * GET /delete  --> Delete a movie from the database.
     *
     * @param id the id
     * @return the map
     */
    public Map<String, Object> delete(ObjectId id) {
        movieRepository.delete(movieRepository.findBy_id(id));
        String msg = "Movie deleted successfully";
        return getStringObjectMap(null, msg, 0, HttpStatus.OK);
    }

    /**
     * GET /read  --> Read all movie from the database.
     *
     * @return the map
     */
    public Map<String, Object> fetchAll() {
        List movie =  movieRepository.findAll();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Movie fetch successfully");
        dataMap.put("count", movie.size());
        dataMap.put("status", HttpStatus.OK.value());
        dataMap.put("data", movie);
        return dataMap;
    }
    /**
     * Function getStringObjectMap
     * This function is used to get string object.
     *
     * @param movie
     *   A movie that contains movie object.
     * @param msg
     *   A msg that contains string message.
     *
     * @return
     *   Return map object.
     */
    private Map<String, Object> getStringObjectMap(Movie movie, String msg, int count, HttpStatus http) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", msg);
        dataMap.put("status", http.value());
        dataMap.put("data", movie != null ? movie : "");
        dataMap.put("count", count);
        return dataMap;
    }
}