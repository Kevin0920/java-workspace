package com.kevin.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kevin.entities.Course;

public interface CourseRepository extends MongoRepository <Course, String> {

	public List<Course> findByTopicId(String topicId);

	
}
 