package com.Java8.newfeature.Java8.otherFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OtherJava8Features {

	void testForEachMethod() {
		List<Integer> myList = new ArrayList<>();		
		for(int i =0; i<10; i++) myList.add(i);
		
		myList.forEach(i -> System.out.println(i));
	}
	
	public interface MyData {

		default void print(String str) {
			if (!isNull(str))
				System.out.println("MyData Print::" + str);
		}

		static boolean isNull(String str) {
			System.out.println("Interface Null Check");

			return str == null ? true : "".equals(str) ? true : false;
		}
	}
	
	void statefulParallelStreamLimitations() {
		List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		List<Integer> result = new ArrayList<Integer>();
		 
		Stream<Integer> stream = ss.stream();
		 
		stream.map(s -> {
//		        synchronized (result) {
//		          
//		        }
			if (result.size() < 10) {
	            result.add(s);
	          }
				return s;
		    }).forEach( e -> {});
		 System.out.println(result); 
	}
	public static void main(String[] args) {
		OtherJava8Features otherJava8Features = new OtherJava8Features();
		otherJava8Features.testForEachMethod();
		
		
//		System.out.println(MyData.isNull(""));	
		otherJava8Features.statefulParallelStreamLimitations();
		

	}
 
 
 
}
