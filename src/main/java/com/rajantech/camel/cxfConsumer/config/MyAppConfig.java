package com.rajantech.camel.cxfConsumer.config;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:spring/cxf-config.xml")
public class MyAppConfig {

    @Autowired
    CamelContext camelContext;

    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            //@Override
            public void beforeApplicationStart(CamelContext context) {
                System.out.println("your custom configuration goes here.");
            }

			//@Override
			public void afterApplicationStart(CamelContext arg0) {
				// TODO Auto-generated method stub
				
			}
        };
    }


    private static int loadOnStartup = 1;
    
    
}
