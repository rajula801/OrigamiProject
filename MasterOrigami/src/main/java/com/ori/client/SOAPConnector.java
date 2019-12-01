package com.ori.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnector extends WebServiceGatewaySupport {
	 
    public Object callWebService(String url, Object request){
        //this is the client soap class
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
