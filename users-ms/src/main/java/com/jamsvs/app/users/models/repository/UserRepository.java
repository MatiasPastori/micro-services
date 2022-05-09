package com.jamsvs.app.users.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.jamsvs.app.users.models.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
