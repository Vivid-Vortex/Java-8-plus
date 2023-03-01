package com.Java8.newfeature.Java8.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.Java8.newfeature.Java8.beans.Employees;
import com.Java8.newfeature.Java8.dblayer.DbLayer;
import com.Java8.newfeature.Java8.streams.ParalellStreamDemo;
import com.Java8.newfeature.Java8.streams.StreamApis;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		
		DbLayer dbLayer = new DbLayer();
		StreamApis test = new StreamApis(dbLayer);
		
//		test.testMap();		
//		test.testFlatMap();	
//		test.testPureOptionalWithoutStream();
		
//		test.testOptionalwithStream();
		
//		test.testMapReduce();
		
		
		ParalellStreamDemo paralellStreamDemo = new ParalellStreamDemo();
//		paralellStreamDemo.testParallelStream();
		
//		Comparator<Customer> compare = new Comparator<Customer> () {
//
//			@Override
//			public int compare(Customer o1, Customer o2) {
//				
//				return o1.getName().compareTo(o2.getName());
//			}
//			
//		};
		
		
//		List<Customer> allCustomer = dbLayer.getAllCustomer();
////		allCustomer.stream().forEach(System.out::println);
//		Collections.sort(allCustomer,(o1,o2) -> o1.getId() - o2.getId());
//		
//		allCustomer.stream().forEach(System.out::println);
		
//			CompareObjects compareObjects = new CompareObjects();
//			compareObjects.sortUsingTreeMap();
//			compareObjects.sortUsingTreeMapButWithObjectsAsKey();
		
//		test.sortMapUsingTraditionalApproach();
//		test.sortMapUsingStreamApi();
		
//		String s = "a";
		
//		Deque<String> deque=new ArrayDeque<String>();  
//	    deque.offer("arvind");  
//	    deque.offer("vimal");  
//	    deque.add("mukul");  
//	    deque.offerFirst("jai"); 
////	    deque.offerFirst("mukul");
////	    deque.offerLast("Jai");
//	    deque.pollLast();
//	    System.out.println("After offerFirst Traversal...");  
//	    for(String s:deque){  
//	        System.out.println(s);  
//	    }  
		//deque.poll();  
		//deque.pollFirst();//it is same as poll()  
//	    deque.pollLast();  
//	    System.out.println("After pollLast() Traversal...");  
//	    for(String s:deque){  
//	        System.out.println(s);  
//	    }
		
		
		
//	   System.out.println(2657860 & 15);
//	   System.out.println(4 & 4);
//		
//		int a = 12;
//        int b = 25;
//  
//        System.out.println("Demonstrating & operator\n");
//        int c = a & b;
//        System.out.println(c);
		
//		Map<String,Integer> treeMap = new TreeMap<>();
//		treeMap.put("eight",8);
//		treeMap.put("four", 4);
//		treeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
//		Employees employees1 = new Employees(1, "Aman", "A", 1000000);
//		Employees employees3 = new Employees(2, "Bman", "B", 900000);
//		Employees employees4 = new Employees(3, "Chaman", "C", 800000);
//		Employees employees2 = new Employees(4, "Gaman", "D", 700000);
//		Employees employees5 = new Employees(5, "Daman", "E", 600000);
//		
//		
//		Map<Integer,Employees> empTreeMap = new TreeMap<>();
//		empTreeMap.put(1,employees1); 
//		empTreeMap.put(4,employees2);
//		empTreeMap.put( 2,employees3);
//		empTreeMap.put(3,employees4);
//		empTreeMap.put(5,employees5);
//		
//		Map<Employees,Integer> empKeyTreeMap = new TreeMap<>();
//		empKeyTreeMap.put(employees1, 1); 
//		empKeyTreeMap.put(employees2, 4);
//		empKeyTreeMap.put(employees3, 2);
//		empKeyTreeMap.put(employees4, 3);
//		empKeyTreeMap.put(employees5, 5);
//		
////		empKeyTreeMap.entrySet().stream()
////		.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees::getSalary)))
////		.forEach(System.out::println);
//		
//		Map<Employees,Integer> empMap = new HashMap<>();
//		empMap.put(employees1, 1); 
//		empMap.put(employees2, 4);
//		empMap.put(employees3, 2);
//		empMap.put(employees4, 3);
//		empMap.put(employees5, 5);
//		
////		empMap.entrySet().stream()
////		.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees::getSalary).reversed()))
////		.forEach(System.out::println);
//		
//		List<String> strList =  new ArrayList<>();
//		strList.add("A");
//		strList.add("B");
//		
//		String[] array = strList.toArray(new String[strList.size()]);
//		System.out.println(array);
		
		//convert list to map
		//test.testConvertListToMap();
		
		test.testConvertMapToList();
       
	}  
		
	
	
	
	
	
	class Book {    
		int id;    
		String name,author,publisher;    
		int quantity;    
		public Book(int id, String name, String author, String publisher, int quantity) {    
		    this.id = id;    
		    this.name = name;    
		    this.author = author;    
		    this.publisher = publisher;    
		    this.quantity = quantity;    
		}    }
		
		 
	class Customer1 {
		int id;
		public Customer1(int id) {
			this.id = id;
		}
	}
		
	
	

}
