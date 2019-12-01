package com.ori.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnector extends WebServiceGatewaySupport {
	 
    public Object callWebService(String url, Object request){
        //this is the client soap class
        // this is another comment
        //this is 3rd commit
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
