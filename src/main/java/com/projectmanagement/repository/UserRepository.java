package com.projectmanagement.repository;

import com.projectmanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findUserByMail(String mail);
    User findUserByUserName(String userName);
}
