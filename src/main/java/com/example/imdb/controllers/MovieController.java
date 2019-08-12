/**
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

package com.example.imdb.controllers;

import com.example.imdb.models.Movie;
import com.example.imdb.services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * GET /create  --> Create a new movie and save it in the database.
     *
     * @param movie
     * @return
     */
//    @PostMapping(value = "/movies", headers="Accept=application/json")
    @RequestMapping(value = "/movies", method = RequestMethod.POST, headers="Accept=application/json")
    public Map<String, Object> post(@Valid @RequestBody Movie movie) {
        return movieService.create(movie);
    }

    /**
     * GET /read  --> Read a movie by movie id from the database.
     *
     * @param id
     * @return
     */
//    @GetMapping(value = "/movies/{id}", headers="Accept=application/json")
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET, headers="Accept=application/json")
    public Map<String, Object> get(@PathVariable("id") ObjectId id) {
        return movieService.read(id);
    }

    /**
     * GET /update  --> Update a movie record and save it in the database.
     *
     * @param id
     * @param movie
     * @return
     */
//    @PutMapping(value = "/movies/{id}", headers="Accept=application/json")
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public Map<String, Object> put(@PathVariable("id") ObjectId id, @Valid @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

    /**
     * GET /delete  --> Delete a movie from the database.
     *
     * @param id
     * @return
     */
//    @DeleteMapping(value = "/movies/{id}", headers="Accept=application/json")
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public Map<String, Object> delete(@PathVariable("id") ObjectId id) {
        return movieService.delete(id);
    }

    /**
     * GET /read  --> Read all movie from the database.
     *
     * @return
     */
//    @GetMapping(value = "/movies", headers="Accept=application/json")
    @RequestMapping(value = "/movies", method = RequestMethod.GET, headers="Accept=application/json")
    public Map<String, Object> getAll() {
        return movieService.fetchAll();
    }



}