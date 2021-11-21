package com.zit.dependencyInjection;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Type;

public final class Container<T> {

	protected static Map<Class<?>, Class<?>> mapServiceImplementation = new HashMap<Class<?>, Class<?>>();

    protected static void clean()
    {
        mapServiceImplementation = new HashMap<>();
        
    }

    /// <summary>
    /// Agrega la relación servicio-implementación al contenedor de inyección de dependencias.
    /// </summary>
    /// <param name="service"></param>
    /// <param name="implementation"></param>    
    protected static void register(Class<?> service, Class<?> implementation)
    {
        if (service == null || implementation == null)
            return;
        String typeService = service.getTypeName();
        String typeImplementation = implementation.getTypeName();
        if (!mapServiceImplementation.containsKey(typeService))
            mapServiceImplementation.put(service, implementation);
        else
            mapServiceImplementation.put(service, implementation);
    }

    /// <summary>
    /// Obtiene una instancia de la implementación de un determinado servicio.
    /// </summary>
    /// <typeparam name="T">Clase Type que corresponde al tipo de servicio</typeparam>
    /// <returns>Instancia de la implementación asociada al servicio</returns>
    /*
      
     
    public static <T> T GetInstance()
    {
        try
        {
        	T pepe;
        	
            Class<?> type = pepe.getClass();
            if (type.getTypeName().Length == 0)
                return (T)Injector.Inject(typeof(pepe));
            return GetInstanceWithGenerics<T>(type.GenericTypeArguments);
        }
        catch (Exception)
        {
            throw new Exception("No se pudo crear una instancia del servicio " + typeof(T).Name + ".");
        }            
    }

    private static <T> T GetInstanceWithGenerics(Type[] attributes)
    {
        try
        {
T pepe;
        	
            Type type = pepe.getClass();
            Type classType = mapServiceImplementation.get(type.getTypeName());
            
            return (T)DIInjector.InjectWithGeneric(typeof(T), attributes);
        }
        catch (Exception ex)
        {
            throw new Exception("No se pudo crear una instancia del servicio " + typeof(T).Name);
        }
        
    }*/
}
