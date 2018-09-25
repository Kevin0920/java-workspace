package com.kevin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Host")
public class HostingCount {
	@Id
	private String id;
	private String hoString;
	private long total;
	public HostingCount(String id, String hoString, long total) {
		super();
		this.id = id;
		this.hoString = hoString;
		this.total = total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoString() {
		return hoString;
	}
	public void setHoString(String hoString) {
		this.hoString = hoString;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
