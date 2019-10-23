package com.ori.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ori.model.Person;

import junit.framework.Assert;

public class FirstTest{

@Test
public void testAddEmployeeWithoutHeader_success() throws URISyntaxException
{
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:8091/display";
    URI uri = new URI(baseUrl);

    Person person = new Person("100","rajula","pullareddy","rajula@gmail.com");
 
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-COM-PERSIST", "true");   
    headers.set("X-COM-LOCATION", "USA");     
    System.out.println("-----------------------rajula");
    HttpEntity<Person> request = new HttpEntity<>(person, headers);
    ResponseEntity<Person> result = restTemplate.postForEntity(uri, request, Person.class);
    
    //System.out.println(result.getBody().getEmail());
 
    Assert.assertEquals(200, result.getStatusCodeValue());
}
}