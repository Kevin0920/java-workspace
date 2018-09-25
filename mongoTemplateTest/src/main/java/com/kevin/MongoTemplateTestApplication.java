package com.kevin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.kevin.dal.PersonDal;
import com.kevin.model.Person;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MongoTemplateTestApplication implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger("AppsDeveloper");

	private PersonDal personDaL;
	
	@Autowired
	public MongoTemplateTestApplication(PersonDal personDal) {
		this.personDaL = personDal;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MongoTemplateTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 personDaL.savePerson(new Person(
		           "Shubham", Arrays.asList("Harry potter", "Waking Up"), new Date(769372200000L)));
		 personDaL.savePerson(new Person(
	           "Sergey", Arrays.asList("Startup Guides", "Java"), new Date(664309800000L)));
	     personDaL.savePerson(new Person(
	           "David", Arrays.asList("Harry potter", "Success"), new Date(695845800000L)));
	     personDaL.savePerson(new Person(
	           "Ivan", Arrays.asList("Secrets of Butene", "Meeting Success"), new Date(569615400000L)));
	     personDaL.savePerson(new Person(
	           "Sergey", Arrays.asList("Harry potter", "Startup Guides"), new Date(348777000000L)));
	     
	     LOG.info("Getting all data from MongoDB: \n{}",
	    		 personDaL.getAllPerson());
	     LOG.info("Getting paginated data from MongoDB: \n{}",
	    		 personDaL.getAllPersonPaginated(0, 2));
	     LOG.info("Getting person By name 'Sergey': {}",
	    		 personDaL.findByName("Sergey"));
	     LOG.info("Getting all person By name 'Sergey': {}",
	    		 personDaL.findOneByName("Sergey"));
	     LOG.info("Getting people between age 22 & 26: {}",
	    		 personDaL.findByAgeRange(22, 26));

	}
}
