package com.Java8.newfeature.Java8.newfeature;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		reverseString("Deepak");

	}
	static void reverseString(String str) {
		char []strArr = str.toCharArray();
		char []tempArr = new char[strArr.length];
		String tempStr = "";
		int j = 0;
		for(int i = strArr.length -1 ;i>=0; i--) {
//			tempStr = tempStr + strArr[i];
			tempArr[j] = strArr[i];
			j++;
		}
		
		System.out.println(tempStr);
	}


}
