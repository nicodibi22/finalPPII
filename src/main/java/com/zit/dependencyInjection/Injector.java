package com.zit.dependencyInjection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Injector {

	protected static Object Inject(Class<?> typeNeedToResolve) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class<?> resolvedType = null;
        try
        {         
            resolvedType = Container.mapServiceImplementation.get(typeNeedToResolve);
            
        }
        catch (Exception ex)
        {
            //throw new ArgumentException(string.Format("Error al buscar una implementación del servicio {0}.", typeNeedToResolve.Name));
        }

        if (resolvedType != null) {
        	Constructor<?>[] firstConstructor = resolvedType.getConstructors();

            Parameter[] constructorParameters = firstConstructor[0].getParameters();

            if (constructorParameters.length == 0) // no tiene parámetros
                return firstConstructor[0].newInstance();
            
            // Llamada recursiva para inyectar las dependencias en profundidad
            List<Object> parameterList = null; 
            Arrays.asList(constructorParameters).forEach((x) -> Inject2(x.getParameterizedType()));
            return firstConstructor[0].newInstance(parameterList.toArray());
	
        }
        return null;
    }

    private static Object Inject2(Type parameterizedType) {
		// TODO Auto-generated method stub
		return null;
	}

	/*protected static Object InjectWithGeneric(Type typeNeedToResolve, Type[] generics)
    {
        Type resolvedType;
        try
        {
            
            resolvedType = Container.mapServiceImplementation.Where(x => x.Key.Name == typeNeedToResolve.Name).FirstOrDefault().Value;
        }
        catch
        {
            throw new Exception(string.Format("Error al buscar una implementación del servicio {0}.", typeNeedToResolve.Name));
        }

        Type constructedType = resolvedType;
        if (resolvedType.IsGenericType)
            constructedType = resolvedType.MakeGenericType(generics);

        var firstConstructor = constructedType.GetConstructors().First();

        var constructorParameters = firstConstructor.GetParameters();
        
        
        
        if (!constructorParameters.Any()) // no tiene parámetros
            return Activator.CreateInstance(constructedType);

        IList<object> parameterList = null;
        // Llamada recursiva para inyectar las dependencias en profundidad
        if (resolvedType.IsGenericType)
            parameterList = constructorParameters.Select(
                parameterToResolve => InjectWithGeneric(parameterToResolve.ParameterType, generics)).ToList();
        else
            parameterList = constructorParameters.Select(
                parameterToResolve => Inject(parameterToResolve.ParameterType)).ToList();

        return firstConstructor.Invoke(parameterList.ToArray());

    }*/
}
