package com.ori.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Student implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 2355756292326754629L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
  	private Long id;
    
	@NotNull
	@Column(name="first_name")
    private String firstName;
    
	@Column(name="last_name")
    private String lastName;
     
    private String year;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getYear() {
        return year;
    }
 
    public void setYear(String year) {
        this.year = year;
    }
         
}