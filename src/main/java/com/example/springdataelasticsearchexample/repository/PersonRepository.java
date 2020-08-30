package com.example.springdataelasticsearchexample.repository;

import com.example.springdataelasticsearchexample.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PersonRepository extends ElasticsearchRepository<Person, String> {
    /**
     * {
     *     "query": {
     *         "bool": {
     *             "must": [
     *                 { "query_string": { "query": "?", "fields": [ "lastName" ] } }
     *             ]
     *         }
     *     }
     * }
     */
    List<Person> findPersonsByLastName(String lastName);
    /**
     * {
     *     "query": {
     *         "bool" : {
     *             "must" : [
     *                 { "query_string" : { "query" : "?", "fields" : [ "lastName" ] } },
     *                 { "query_string" : { "query" : "?", "fields" : [ "age" ] } }
     *             ]
     *         }
     *     }
     * }
     */
    List<Person> findPersonsByLastNameAndAge(String lastName, int age);
}
