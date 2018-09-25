package com.kevin.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	
	@Id
	private String id;
	private String password;
	private String name;
	private String gender;
	private Date createTime;
	@DBRef
	private List<Order> orders;



	public User(List<Order> orders, String id, String password, String name, String gender, Date createTime) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.createTime = createTime;
		this.orders = orders;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Order> getOrders() {
		return orders;
	}
	
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
	
	
}
