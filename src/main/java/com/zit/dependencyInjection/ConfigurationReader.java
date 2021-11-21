package com.zit.dependencyInjection;

import java.io.File;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.zit.dependencyInjection.dominio.Servicios;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.*;

public class ConfigurationReader {

	private static ConfigurationReader instance;
	
	private ConfigurationReader() {
		readConfigurationFile();
	}
	
	
	public static ConfigurationReader getInstance() {
		if (instance == null)
			instance = new ConfigurationReader();
		return instance;
	}
	
	private void readConfigurationFile() {		         
        try{
    		Servicios listServices = new Servicios();
    		listServices = ConfigurationXmlParser.<Servicios>getObjectFromFile("servicios.xml");      
             
        } catch (JAXBException jaxbe){
            jaxbe.printStackTrace();
        } catch (Exception fnfe) {
            fnfe.printStackTrace();
        }		
	}
}

