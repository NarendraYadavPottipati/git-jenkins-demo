package com.backend.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;


import com.backend.database.databasedemo.entity.Person;

public interface SpringDataJpaRepository extends JpaRepository<Person,Integer>{

}
