package com.zit.dependencyInjection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

private static PropertiesReader instance = null;
	
	public static PropertiesReader getInstance() {
	      if(instance == null) {
	         instance = new PropertiesReader();
	      }
	      return instance;
	   }
	
	public String getPropiedad(String key) throws IOException  {
		InputStream inputStream;
		
		String value = "";					
		inputStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");			
		Properties props = new Properties();
	    props.load(inputStream);		 
	    value = props.getProperty(key);	
	    inputStream.close();
		
		return value;
	}
}
