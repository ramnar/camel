package com.ramnar.camelservice;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.ramnar.model.MessageAudit;

public class JPAProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.setProperty("response", exchange.getIn().getBody());
		MessageAudit messageAudit = new MessageAudit();
		messageAudit.setId(10);
		messageAudit.setMessage((String)exchange.getProperty("message"));
		messageAudit.setMobileNo((String)exchange.getProperty("mobile"));
		exchange.getIn().setBody(messageAudit);
	}

}
