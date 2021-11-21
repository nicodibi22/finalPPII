package com.zit.dependencyInjection.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "servicios")
public class Servicios {

	private List servicios;
	public List getServicios() {
        return servicios;
    }
	
	@XmlElement(name = "servicio")
    public void setServicios(List servicios) {
        this.servicios = servicios;
    }
 
    public void add(Servicio servicio) {
        if (this.servicios == null) {
            this.servicios = new ArrayList();
        }
        this.servicios.add(servicio);
 
    }
}
