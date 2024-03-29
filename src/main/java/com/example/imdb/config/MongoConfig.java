/**
 *
 * @author  Sanjeev Kumar
 * @version 1.0
 * @since   2019-Aug-12
 */

package com.example.imdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;

/**
 * The type Mongo config.
 */
@Configuration
@EnableMongoRepositories(basePackages="com.example.imdb.repositories")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "idbm"; //name of database in mongo
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        // ip and port for mongodb
        return new MongoClient("localhost", 27017);
    }
}
