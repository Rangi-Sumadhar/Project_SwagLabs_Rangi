package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLibrary implements FrameworkConstant
{
	static Properties property;
	static FileInputStream 	fis;
	static FileOutputStream fos;
	
	public static String ReadData(String Key)
	{
		//1. Convert the external file into java understandable language
		try {
			fis = new FileInputStream(properties_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//2. Create an object for property class
		property = new Properties();
		
		//3.Load all the properties using properties class variable
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//4.Read or fetch the data 
		
		return property.getProperty(Key);
	}
	
	
	
	
	
	public static void WriteData(String newkey, String newdata, String message)
	{
				//1. Convert the external file into java understandable language
				try {
					fis = new FileInputStream(properties_path);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				
				//2. Create an object for property class
				property = new Properties();
				
				//3.Load all the properties using properties class variable
				try {
					property.load(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//4.Put the data in the properties file
				
				property.put(newkey, newdata);
				
				//5.Convert the java understandable file to external file
				
				try {
					fos = new FileOutputStream(properties_path);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				//6. Store the new data in the file path using fos 
				
				try {
					property.store(fos, message);
				} catch (IOException e) {
					e.printStackTrace();
				}			
	}	
}





