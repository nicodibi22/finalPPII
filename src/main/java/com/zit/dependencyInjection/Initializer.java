package com.zit.dependencyInjection;

import java.io.FileNotFoundException;
import java.io.IOException;
import javassist.tools.rmi.ObjectNotFoundException;

public class Initializer {

	/// <summary>
    /// Inicializa el inyector de dependencias de acuerdo a las configuraciones seteadas.
    /// </summary>
    public static void initialize() throws IOException, FileNotFoundException, ObjectNotFoundException
    {
        try
        {
            Container.clean();
            
            if (PropertiesReader.getInstance().getPropiedad(Constants.PROPERTY_CONFIGURATION_FILE) == null
            		|| PropertiesReader.getInstance().getPropiedad(Constants.PROPERTY_CONFIGURATION_FILE).isEmpty())
            	throw new ObjectNotFoundException("No se agregó la configuración correspondiente: " + Constants.PROPERTY_CONFIGURATION_FILE + ".");
            ConfigurationManager serviceManager = ConfigurationManager.getInstance();
            while (serviceManager.hasNextService())
            {
                //TypeInfo typeService = serviceManager.nextService();
                //TypeInfo typeClass = ServiceLoader.LoadImplementation(typeService);
                //DIContainer.Register(typeService, typeClass);
            }
        }
        catch (FileNotFoundException ex) {
            throw new FileNotFoundException("No se encontró archivo de configuracion.");
        }
        catch (IOException ex) {
        	throw new IOException("No se encontró archivo de recursos.");
        } 
    }

    public static void initializeWithConfigurationFile(String configurationFile) throws IOException, FileNotFoundException, ObjectNotFoundException
    {
        //ServiceLoader.SetConfigurationFile(configurationFile);
        initialize();
    }
}
