package com.santoshkumawat.journalApp.repository;

import com.santoshkumawat.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByUserName(String userName);
}
