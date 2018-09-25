package com.kevin.entities;

public class GroupResult {
	
	private Integer count;
	private String groupName;
	
	
	public GroupResult(Integer count, String groupName) {
		super();
		this.count = count;
		this.groupName = groupName;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	
}
