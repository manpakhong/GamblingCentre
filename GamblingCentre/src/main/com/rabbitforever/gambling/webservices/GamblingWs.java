package com.rabbitforever.gambling.webservices;

import javax.ws.rs.Path;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/gamblingWs")
public class GamblingWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}
	
}
