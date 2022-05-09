package com.jamsvs.app.courses.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.jamsvs.app.courses.models.entity.Course;

public interface CoursesRepository extends CrudRepository<Course, Long> {

}
