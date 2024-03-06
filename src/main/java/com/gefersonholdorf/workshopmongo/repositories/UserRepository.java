package com.gefersonholdorf.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gefersonholdorf.workshopmongo.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
