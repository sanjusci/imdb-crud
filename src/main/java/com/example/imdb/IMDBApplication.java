/**
 * The IMDBApplication program implements an application that
 * simply run `IMDB Application` to the standard output.
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

package com.example.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * The type Imdb application.
 */
@RestController
@SpringBootApplication
public class IMDBApplication {

    /**
     * Home map.
     *
     * @return the map
     */
    @RequestMapping("/")
    Map<String, Object> home() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Welcome to your first Spring boot Application!");
        dataMap.put("status", HttpStatus.ACCEPTED);
        return dataMap;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(IMDBApplication.class, args);

    }
}