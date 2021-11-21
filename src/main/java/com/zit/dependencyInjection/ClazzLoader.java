package com.zit.dependencyInjection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClazzLoader {

	/**
	 * 
	 * @return
	 */
	public static Class<?>[] getImplementationsPackage(String packageName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		return null;
	}
	
	public static Class<?>[] getImplementationsByLibrary(String libraryName, String packageName) throws IOException, ClassNotFoundException {
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		List<Class<?>> classes = new ArrayList<>();
        
		JarFile file = new JarFile(libraryName);	    
        Enumeration<JarEntry> entries = file.entries();
        while (entries.hasMoreElements()) {
            JarEntry cls = entries.nextElement();
            if (!cls.isDirectory()) {
                String fileName = cls.getName();
                String className = fileName.replaceAll("/",".").replaceAll(File.pathSeparator, ".");//.substring(0, fileName.lastIndexOf('.'));
                if (className.startsWith(packageName)) 
                	classes.add(Class.forName(className));
                else
                	classes.add(Class.forName("com.zit.dependencyInjection.Injector"));
            }
        }
        Class<?>[] arrayClasses = new Class<?>[classes.size()];
        file.close();
		return classes.toArray(arrayClasses);
	}
}
