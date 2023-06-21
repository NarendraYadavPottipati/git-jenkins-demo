package com.backend.database.databasedemo.springdata;

import java.util.Date;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.backend.database.databasedemo.entity.Person;
import com.backend.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
@EntityScan("com.backend.database.databasedemo.entity")
public class SpringDataJPADemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()) ;
   
	@Autowired
	SpringDataJpaRepository jpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Finding by ID using JPA: {}", jpaRepository.findById(10001));
		logger.info("Inserting a new perosn with id {}",10004,jpaRepository.save(new Person("Satya","Rajamandry")));
		logger.info("Updating a new person where id ={}",10003,jpaRepository.save(new Person(10003,"Bala Chowdappa","Anantapur")));
		jpaRepository.deleteById(10003);
		logger.info("\n All persons -> {} ",jpaRepository.findAll());
		/*
     		logger.info("\n All persons -> {} ",dao.findAll());
     		//logger.info("Person with id {} is {}",10001,dao.findById(10001));
     		logger.info("Inserting a new perosn with id {}",10004,dao.insert(new Person(10004,"Satya","Rajamandry",new Date())));
     		logger.info("Updating a new person where id ={}",10003,dao.updatePerson(new Person(10003,"Bala Chowdappa","Anantapur",new Date())));
            logger.info("Deleting a person with id={}",10002,dao.deletePerson(10002));	
	*/
	}

}
