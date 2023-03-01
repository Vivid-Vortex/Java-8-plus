package com.Java8.newfeature.Java78.IO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InputOutputDemo {

	static void  readPropertyFile() throws IOException {
		FileReader reader=new FileReader("D:/db.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	      
	    System.out.println(p.getProperty("user"));  
	    System.out.println(p.getProperty("password")); 
	}
	
	public static void main(String[] args) throws IOException {
		InputOutputDemo.readPropertyFile();
	}
}
