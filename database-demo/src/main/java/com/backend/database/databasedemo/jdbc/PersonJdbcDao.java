package com.backend.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.backend.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			return person;
		}
		
	}
	
	/*public List<Person> findAll(){
		return jdbcTemplate.query("select * from Person", new PersonRowMapper());
	}
	
	public Person findById(int id) {
		return (Person) jdbcTemplate.queryForObject("select * from Person where id=?",new Integer[] {id},
				new BeanPropertyRowMapper(Person.class)); 
	}
	public int insert(Person person) {
		int n =jdbcTemplate.update("insert into person (id,name,location,birthDate) values(?,?,?,?)", new Object[] {
				person.getId(),person.getName(),person.getLocation()});
		return n;
	}
	
	public int updatePerson(Person person) {
		int n =jdbcTemplate.update("update person set name=?, location=?, birthDate=?  where id=? ", new Object[] {
			person.getName(), person.getLocation(), person.getId()});
		return n;
	}
	
	public int deletePerson(int id) {
		int n= jdbcTemplate.update("delete person where id =?",new Object[] {id});
		return n;
	}*/

}
