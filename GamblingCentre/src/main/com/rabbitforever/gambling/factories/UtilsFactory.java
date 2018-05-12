package com.rabbitforever.gambling.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.gambling.utils.HibernateUtils;

public class UtilsFactory {
	private final static Logger logger = LoggerFactory.getLogger(PropertiesFactory.class);
	private final static String className = PropertiesFactory.class.getName();
	

	private static UtilsFactory utilsFactory;
	private UtilsFactory(){
		
	}
	
	public static UtilsFactory getInstance() {
		if (utilsFactory == null) {
			utilsFactory = new UtilsFactory();
		}
		return utilsFactory;
	}
}
