package com.rajantech.camel.cxfConsumer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CxfConsumerRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("timer://foo?period=5000")
		.log("timer working")
		.to("velocity:calculator.vm")
		.log("before calling soap ${body}")
		.setHeader("SOAPAction").constant("http://tempuri.org/Add")
		.to("cxf:bean:Addition?dataFormat=MESSAGE")
		.log("####### ${body}")
		;
		
	}

}
