package com.jamsvs.app.courses.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jamsvs.app.commons.users.models.entity.User;
import com.jamsvs.app.courses.models.entity.Course;
import com.jamsvs.app.courses.services.CoursesService;
import com.jamsvs.commons.controllers.CommonController;

@RestController
public class CourseController extends CommonController<Course, CoursesService> {

	@PutMapping("/{id}")
	ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable Long id) {
		Optional<Course> optionalCourse = this.service.findById(id);
		if (!optionalCourse.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course persistedCourse = optionalCourse.get();
		persistedCourse.setName(course.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(persistedCourse));

	}

	@PutMapping("/{id}/asign-users")
	public ResponseEntity<?> asignUsers(@RequestBody List<User> users, @PathVariable Long id) {
		Optional<Course> optionalCourse = this.service.findById(id);
		if (!optionalCourse.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Course persistedCourse = optionalCourse.get();

		users.forEach(user -> {
			persistedCourse.addUsers(user);
		});

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(persistedCourse));

	}

}
