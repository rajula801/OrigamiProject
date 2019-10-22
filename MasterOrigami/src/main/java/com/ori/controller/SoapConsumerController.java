package com.ori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.rajula.schemas.student.ObjectFactory;
import com.example.rajula.schemas.student.Student;
import com.example.rajula.schemas.student.StudentDetailsRequest;
import com.example.rajula.schemas.student.StudentDetailsResponse;
import com.ori.client.SOAPConnector;

@RestController
public class SoapConsumerController {
	
	/* in order to consume soap service
	 * 1. Add wsdl file in resource/wsdl folder
	   2. add web service( spring-boot-starter-web-services ) dependency in pom.xml 
	   3. Add maven-jaxb2-plugin into plugin section in pom.xml
	   4. build the maven and Generate the stub classes in com.example.rajula.schemas.student 
	   5. Write config class to create bean for marshaller and soapconnector
	   6. Write client SoapConnector class to call webservice which extends WebServiceGatewaySupport. 
	   7. call the web service
	
	*/
	
	@Autowired
	private SOAPConnector soapConnector;
	
	@GetMapping("/soapstudent/{name}")
	public Student getStudentDetails(@PathVariable String name) {
		ObjectFactory of = new ObjectFactory();
		
		StudentDetailsRequest request = of.createStudentDetailsRequest();
		request.setName(name);
		StudentDetailsResponse response = (StudentDetailsResponse)soapConnector.callWebService("http://localhost:8091/service/student-details", request);
		Student st = response.getStudent();
		return st;
	}

}
