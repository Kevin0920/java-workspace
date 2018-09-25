package com.kevin.entities;



public class Course {

	private String name;
	private String description;
	
	private Topic topic;
 
	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public Course() {
		
	}
	

	public Course(String id, String name, String description, String topicId) {
		super();
		this.name = name;
	 	this.description = description;
	 	this.topic = new Topic();
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
