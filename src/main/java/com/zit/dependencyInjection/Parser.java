package com.zit.dependencyInjection;

import java.io.File;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.zit.dependencyInjection.dominio.Servicios;

public abstract class Parser<T> {

	public abstract Set<T> parse(String str);
	
	T read(String fileName) throws Exception {
		return readXml(fileName);
	}
	
	@SuppressWarnings("unchecked")
	T readXml(String fileName) throws Exception {
		
		File file = new File(fileName);
        JAXBContext jaxbContext;
		try {
			file.exists();
			jaxbContext = JAXBContext.newInstance(Servicios.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	        return (T) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
        
	}
}
