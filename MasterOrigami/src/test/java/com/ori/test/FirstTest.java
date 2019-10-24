package com.ori.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ori.model.EmployeeAddresses;
import com.ori.model.Person;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FirstTest{

@Test
public void testPost_Header_success() throws URISyntaxException
{
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:8091/display";
    URI uri = new URI(baseUrl);

    Person person = new Person("100","rajula","pullareddy","rajula@gmail.com");
 
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-COM-PERSIST", "true");   
    headers.set("X-COM-LOCATION", "USA");     
    HttpEntity<Person> request = new HttpEntity<>(person, headers);
    ResponseEntity<Person> result = restTemplate.postForEntity(uri, request, Person.class);
    
    //System.out.println(result.getBody().getEmail());
 
    Assert.assertEquals(200, result.getStatusCodeValue());
}

@Test
public void testAsyn_Success() {
	
	RestTemplate restTemplate = new RestTemplate();
	EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8091/addresses", EmployeeAddresses.class);

	System.out.println("employeeAddressData, {}"+ employeeAddressData);
	
}
}