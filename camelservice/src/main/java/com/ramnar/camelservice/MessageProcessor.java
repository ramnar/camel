package com.ramnar.camelservice;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.codehaus.jackson.map.ObjectMapper;

import com.ramnar.model.MsgRequest;

public class MessageProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String request = exchange.getIn().getBody(String.class);
		MsgRequest msgRequest = new ObjectMapper().readValue(request, MsgRequest.class);
		exchange.setProperty("mobile", msgRequest.getMobileNo());
		exchange.setProperty("message", msgRequest.getMessage());

		
	}

}
