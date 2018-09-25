package com.kevin.model;

import java.util.Date;
import java.util.List;
import static java.util.Calendar.*;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {
	@Id
	private String personId;
	private String name;
	private long age;
	private List<String> favoriteBooks;
	private Date dateOfBirth;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Person(String name, List<String> childrenName, Date dateOfBirth) {
	   this.name = name;
       this.favoriteBooks = childrenName;
       this.dateOfBirth = dateOfBirth;
       this.age = getDiffYears(dateOfBirth, new Date());
	}
	
   private int getDiffYears(Date first, Date last) {
       Calendar a = getCalendar(first);
       Calendar b = getCalendar(last);
       int diff = b.get(YEAR) - a.get(YEAR);
       if (a.get(MONTH) > b.get(MONTH) ||
               (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
           diff--;
       }
       return diff;
   }
   private Calendar getCalendar(Date date) {
       Calendar cal = Calendar.getInstance(Locale.US);
       cal.setTime(date);
       return cal;
   }
   
   @Override
   public String toString() {
       return String.format("Person{personId='%s', name='%s', age=%d, dateOfBirth=%s}\n",
               personId, name, age, dateOfBirth);
   }


	public String getPersonId() {
		return personId;
	}


	public void setPersonId(String personId) {
		this.personId = personId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getAge() {
		return age;
	}


	public void setAge(long age) {
		this.age = age;
	}


	public List<String> getFavoriteBooks() {
		return favoriteBooks;
	}


	public void setFavoriteBooks(List<String> favoriteBooks) {
		this.favoriteBooks = favoriteBooks;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
}
