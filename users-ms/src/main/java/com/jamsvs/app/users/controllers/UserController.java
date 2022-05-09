package com.jamsvs.app.users.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jamsvs.app.users.models.entity.User;
import com.jamsvs.app.users.services.UserService;
import com.jamsvs.commons.controllers.CommonController;

@RestController
public class UserController extends CommonController<User, UserService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
		Optional<User> optionalUser = service.findById(id);
		if (optionalUser.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		User persistedUser = optionalUser.get();
		persistedUser.setFirstname(user.getFirstname());
		persistedUser.setLastname(user.getLastname());
		persistedUser.setEmail(user.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(persistedUser));
	}

}
