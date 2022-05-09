package com.jamsvs.app.courses.services;

import org.springframework.stereotype.Service;

import com.jamsvs.app.courses.models.entity.Course;
import com.jamsvs.app.courses.models.repository.CoursesRepository;
import com.jamsvs.commons.services.CommonServiceImpl;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, CoursesRepository> implements CoursesService {

}
