package com.Java8.newfeature.Java8.comarator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.Java8.newfeature.Java8.beans.Employees;

public class CompareObjects {
	
	public void sortUsingTreeMap() {
//		Map<String, Employees> map = new HashMap<>();
//		Employees employees1 = new Employees(1, "Mher", "A", 60000);
//		
//		map.put(employees1.getName(), employees1);
//		
//		Employees employees2 = new Employees(22L, "Annie", "A", 60000);
//		map.put(employees2.getName(), employees2);
//		
//		Employees employees3 = new Employees(22L, "John", "A", 60000);
//		map.put(employees3.getName(), employees3);
//		
//		Employees employees4 = new Employees(22L, "George", "A", 60000);
//		map.put(employees4.getName(), employees4);
//		
//		System.out.println(map);
//		TreeMap<String, Employees> sorted = new TreeMap<>(map);
		
//		System.out.println(sorted);
		
		
	}
	
	
	public void sortUsingTreeMapButWithObjectsAsKey() {
		Map<Employees, String> map = new HashMap<>();
		Employees employees1 = new Employees(1, "Mher", "A", 60000);
		
		map.put(employees1, employees1.getName() );
		
		Employees employees2 = new Employees(22L, "Annie", "A", 60000);
		map.put(employees2, employees2.getName());
		
		Employees employees3 = new Employees(22L, "John", "A", 60000);
		map.put(employees3, employees3.getName());
		
		Employees employees4 = new Employees(22L, "George", "A", 60000);
		map.put(employees4, employees4.getName());
		
		System.out.println(map);
		
		TreeMap<Employees, String> sorted = new TreeMap<>(map);
//		TreeMap<Employees, String> sorted = new TreeMap<>(map);
		
	}
}
