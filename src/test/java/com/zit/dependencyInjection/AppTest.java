package com.zit.dependencyInjection;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    @Test
    public void shouldAnswerWithTrue() throws ClassNotFoundException, IOException
    {
    	String pepe = PropertiesReader.getInstance().getPropiedad("ZitDependencyInjectionConfigurationFile");
    	//ClazzLoader.getImplementationsByLibrary("C:\\Users\\nidibiase\\git\\RompecabezasDeslizante\\forms-1.3.0.jar", "com.jgoodies.forms.builder");
        assertTrue(pepe.equals("services.xml"));
    	assertTrue( true );
        
    }
}
