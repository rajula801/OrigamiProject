package com.ori;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ori.model.Employee;

public class GsonClass {
	
	public static void main(String args[]) {
		//Google GSON library to serialize Java Objects into their JSON representation and 
		//to deserialize a JSON string to an equivalent Java object. 
		//GSON provides simple toJson() and fromJson() methods to convert Java objects to JSON and vice-versa.
		
		Gson gson = new GsonBuilder().create();
		
		//serialize javaobject into json string
		Employee emp = new Employee("100","rajula","pullareddy","rajula@gmail.com");
		
		String gsonStr = gson.toJson(emp);
		
		System.out.println(gsonStr);
		
		Employee e = gson.fromJson(gsonStr,Employee.class);
		
		System.out.println(e.getFirstName());
		
		
	}
	

}
