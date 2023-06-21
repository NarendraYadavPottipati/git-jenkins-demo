package com.backend.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.database.databasedemo.entity.Person;
//import com.backend.database.databasedemo.jdbc.PersonJdbcDao;

/*//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()) ;
    @Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
     		logger.info("\n All persons -> {} ",dao.findAll());
     		//logger.info("Person with id {} is {}",10001,dao.findById(10001));
     		logger.info("Inserting a new perosn with id {}",10004,dao.insert(new Person(10004,"Satya","Rajamandry",new Date())));
     		logger.info("Updating a new person where id ={}",10003,dao.updatePerson(new Person(10003,"Bala Chowdappa","Anantapur",new Date())));
            logger.info("Deleting a person with id={}",10002,dao.deletePerson(10002));	
	}

}*/
