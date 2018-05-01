package com.rabbitforever.gambling.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//http://localhost:8080/GamblingCentre/rest/gamblingWs/test
//http://localhost:8080/GamblingCentre/rest/gamblingWs/requestInspectionJson
@Path("/gamblingWs")
public class GamblingWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}
	@GET
	@Path("/test")
	@Produces("text/plain")
	public String test(){ 
		String returnString = "";
		try{
			returnString = "Test return from Gambling Test()";
		}catch (Exception e){
			logger.error(getClassName() + ".test() - Exception: ", e);
		}
		return returnString;
	}
}
