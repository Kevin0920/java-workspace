package com.kevin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.entities.Course;
import com.kevin.repositories.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("srping", "spring framework", "spring set up"),
//			new Topic("java", "java spring framework", "spring set up"),
//			new Topic("javascript", "MEAN stack", "spring set up")
//	));
//	
	
	// get all data from a new create array list 
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	// mapping the topics array by matching id whatever find first get it
	public Optional<Course> getCourse(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void createCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(String id, Course course) {
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}

	
	
}
