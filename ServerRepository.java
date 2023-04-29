package com.project.springbootmongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepository extends MongoRepository<Server,String> {

    List<Server> findByNameContaining(String name);

    List<Server> findByNameContainingIgnoreCase(String name);
