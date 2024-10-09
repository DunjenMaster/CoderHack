package com.crio.coderhack.repositories;

import com.crio.coderhack.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByOrderByScoreDesc(); // Custom method to retrieve users sorted by score
}
