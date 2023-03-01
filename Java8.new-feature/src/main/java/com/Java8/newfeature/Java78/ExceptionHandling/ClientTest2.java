package com.Java8.newfeature.Java78.ExceptionHandling;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class ClientTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		File propFile = new File("");
		try {
			readFile(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			writeLogsToLogsFile(e);
		}
	}

	private static void readFile(File fileName) throws FileNotFoundException, EOFException, IllegalArgumentException {
		if (fileName == null || fileName.getPath().equals("")) {
			throw new IllegalArgumentException("File Name not given");
		}
		InputStream in = new FileInputStream(fileName);
		// Rest of the code goes here
	}
	
	public static void writeLogsToLogsFile(Exception e) throws FileNotFoundException {
		File file = new File("D:/logs");
		PrintWriter printWriter = new PrintWriter(file );
		printWriter.append("Excepton Occured :"+e);
		printWriter.close();
	}
}