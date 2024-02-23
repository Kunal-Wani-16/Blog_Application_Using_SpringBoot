package com.kunal.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/*
	 GenerationType.IDENTITY: This strategy will help us to generate the primary key value by the database itself using the auto-increment column option. It relies on the database’s native support for generating unique values. 
GenerationType.AUTO: This is a default strategy and the persistence provider which automatically selects an appropriate generation strategy based on the database usage.
GenerationType.TABLE: This strategy uses a separate database table to generate primary key values. The persistence provider manages this table and uses it to allocate unique values for primary keys.
GenerationType.SEQUENCE: This generation-type strategy uses a database sequence to generate primary key values. It requires the usage of database sequence objects, which varies depending on the database which is being used. 
	  
	
	 */
	private int id;
	
	@Column(name="user_name",nullable = false,length = 100)
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)// Lazy means it does not delete tuple from child table
	private List<Post>posts=new ArrayList<>();
}
