package com.zit.dependencyInjection;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.zit.dependencyInjection.dominio.Servicios;

public class ConfigurationXmlParser<T> {

	
	
	@SuppressWarnings("unchecked")
	public static <T> T getObjectFromFile(String fileName) throws JAXBException {
		
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(Servicios.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(file);
		
	}
}
