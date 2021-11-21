package com.zit.dependencyInjection;

import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.*;

public class ConfigurationManager {

	private static ConfigurationManager instance;
	
	
	public static ConfigurationManager getInstance() {
		if (instance == null)
		{
			instance = new ConfigurationManager();
		}
		return instance;
	}
	
	private void loadConfigurationFile() throws IOException {
		
		ConfigurationReader.getInstance();
	}
	
	public void loadServices() {
		
	}
	
	public boolean hasNextService() {
		return false;
	}
	
	public void nextService() {
		
	}
}
