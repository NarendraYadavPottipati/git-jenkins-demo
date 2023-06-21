package com.backend.database.databasedemo.jpa;



import java.util.List;


import org.springframework.stereotype.Repository;

import com.backend.database.databasedemo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	public void deleteById(int id) {
		Person personToDelete = findById(id);
		entityManager.remove(personToDelete);
	}
	public List<Person> findAll() {
		Query namedQuery = entityManager.createNamedQuery("find_all_persons");
		return namedQuery.getResultList();
	}
}

/*

Sure! Let's explain each of these in detail:

1. `@Transactional` Annotation:
   - The `@Transactional` annotation is used to mark a method, class, or interface as participating in a transaction.
   - When applied to a method, it ensures that the method is executed within a transactional context, providing the necessary isolation, consistency, and atomicity guarantees.
   - The annotation can be applied at the method level or at the class level. When applied at the class level, all public methods of that class are considered transactional.
   - By default, transactions are configured to roll back on any unchecked exception. You can customize the behavior using additional attributes of the `@Transactional` annotation.
   - This annotation is commonly used in Spring applications to manage database transactions, but it can be used in other scenarios where transactional behavior is required.

2. `@PersistenceContext` Annotation:
   - The `@PersistenceContext` annotation is used to inject an `EntityManager` into a Spring-managed bean.
   - The `EntityManager` represents the persistence context, which is the interface to the underlying database.
   - When the `@PersistenceContext` annotation is used, Spring injects the appropriate `EntityManager` instance based on the current transactional context.
   - The annotation can be applied to a field, setter method, or constructor parameter.
   - By default, the `EntityManager` is transaction-scoped, meaning that it is created and associated with the current transaction. It allows you to perform database operations within the transaction boundary.
   - The `@PersistenceContext` annotation is part of the Java Persistence API (JPA) and is typically used in JPA-based applications to manage the persistence context.

3. `EntityManager` Interface:
   - The `EntityManager` interface is the primary interface for interacting with the persistence context in JPA.
   - It provides methods to perform database operations, such as querying, inserting, updating, and deleting entities.
   - The `EntityManager` represents a connection to the underlying database and manages the lifecycle of entities within the persistence context.
   - It allows you to create, persist, load, modify, and remove entities from the database.
   - The `EntityManager` is responsible for translating Java object operations into corresponding database operations.
   - It also provides methods for executing queries, managing transactions, and controlling the caching behavior.
   - The `EntityManager` is typically obtained through dependency injection or by using the `@PersistenceContext` annotation in a managed environment (such as Spring).
   - In JPA, the `EntityManager` is used to interact with entities and perform various persistence operations.

In summary, `@Transactional` is an annotation used to mark methods or classes as participating in transactions,
 `@PersistenceContext` is an annotation used to inject an `EntityManager` into a Spring-managed bean, 
 and `EntityManager` is the primary interface for interacting with the persistence context in JPA. These components are often used together 
 to manage transactions and perform database operations in Java applications.  */