package com.kevin.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Topics")
public class Topic {
	
	@Id
	private String id;
	private String name;
	
	private List<Course> courses;
	
	
	public Topic() {
		this.setCourses(new ArrayList<>());
	}
	
	public Topic(String id, String name, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.setCourses(courses);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
}
