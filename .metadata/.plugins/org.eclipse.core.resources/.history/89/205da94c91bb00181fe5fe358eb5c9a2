package com.kevin.rest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.kevin.entities.Education;
import com.kevin.entities.Person;


@RestController
@RequestMapping(value="/api")
public class PersonRest {
	
	@RequestMapping(method=RequestMethod.GET, value="/person")
	public Person getPerson(@RequestParam(value = "firstName", required = false) String firstName) throws ParseException {
		Person personData = new Person();
		if (firstName != null) {
			personData.setFirstName(firstName);			
		}
		else {
			personData.setFirstName("Kevin");
		}
		personData.setLastName("Ke");
		
		personData.getAddress().setCivicNumber(23);
		personData.getAddress().setStreetName("123 1st Ave");
		personData.getAddress().setCity("Fuzhou");
		personData.getAddress().setState("Fuzhou");
		personData.getAddress().setCountry("China");
		personData.getAddress().setZipCode("99999");
		
		
		Education eduList = new Education();
		DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		eduList.setInstitution("UC Davis");
		eduList.setDateEncrolled(sdf.parse("2000-01-01"));
		eduList.setDataCompleted(sdf.parse("2004-09-30"));
		eduList.getAddress().setCivicNumber(999);
		eduList.getAddress().setStreetName("University Ave");
		eduList.getAddress().setCity("Davis");
		eduList.getAddress().setState("California");
		eduList.getAddress().setZipCode("10000");
		eduList.getAddress().setCountry("USA");
		
		personData.getEducationList().add(eduList);
		
		return personData;
	}

}
