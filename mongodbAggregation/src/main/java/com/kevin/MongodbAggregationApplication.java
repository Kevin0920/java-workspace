package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevin.model.HostingCount;



@SpringBootApplication
public class MongodbAggregationApplication {
	
	private TestRepository testRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MongodbAggregationApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		testRepository.save(new HostingCount("1", "Kevhostgator.com", 2));
		testRepository.save(new HostingCount("2", "aws.amazon.com", 20));
		testRepository.save(new HostingCount("3", "godaddy.com", 100));
		
	}
}
