package com.Java8.newfeature.Java8.dblayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.Java8.newfeature.Java8.beans.Customer;
import com.Java8.newfeature.Java8.beans.Employees;

//@Component
public class DbLayer {

	public List<Customer> getAllCustomer() {
		List<Customer> custList = new ArrayList<Customer>();

		custList.add(new Customer(1, "Aman", "aman@gmail.com", Arrays.asList("923334444", "923334445")));
		custList.add(new Customer(2, "Bman", "Bman@gmail.com", Arrays.asList("923334446", "923334449")));
		custList.add(new Customer(3, "Chaman", "Chaman@gmail.com", Arrays.asList("923334447", "923334845")));
		custList.add(new Customer(4, "Gaman", "Gaman@gmail.com", Arrays.asList("923334448", "923334495")));
		custList.add(new Customer(5, "Gagan", "Gagan@gmail.com", Arrays.asList("923334449", "923334495")));

		return custList;
	}
	
	public Map<Customer,String> getAllCustomerAsMap() {
		Map<Customer,String> custMap = new HashMap<Customer,String>();

		custMap.put(new Customer(1, "Aman", "aman@gmail.com", Arrays.asList("923334444", "923334445")),"Aman");
		custMap.put(new Customer(2, "Bman", "Bman@gmail.com", Arrays.asList("923334446", "923334449")),"Bman");
		custMap.put(new Customer(3, "Chaman", "Chaman@gmail.com", Arrays.asList("923334447", "923334845")),"Chaman");
		custMap.put(new Customer(4, "Gaman", "Gaman@gmail.com", Arrays.asList("923334448", "923334495")),"Gaman");
		custMap.put(new Customer(5, "Gagan", "Gagan@gmail.com", Arrays.asList("923334449", "923334495")),"Gagan");

		return custMap;
	}
	
	public List<Employees> getEmployees() {
		List<Employees> empList = new ArrayList<Employees>();

		empList.add(new Employees(1, "Aman", "A", 60000));
		empList.add(new Employees(2, "Bman", "B", 30000));
		empList.add(new Employees(3, "Chaman", "A", 80000));
		empList.add(new Employees(4, "Gaman", "A", 90000));
		empList.add(new Employees(5, "Gagan", "C", 15000));

		return empList;
	}

	public List<Customer> getCustStrema() {
		/**
		 * Stream of(T t) returns a sequential Stream containing a single element.
		 */
		return Stream.of(new Customer(1, "Aman", "aman@gmail.com", Arrays.asList("923334444", "923334445")),
				new Customer(2, "Bman", "Bman@gmail.com", Arrays.asList("923334446", "923334449")),
				new Customer(3, "Chaman", "Chaman@gmail.com", Arrays.asList("923334447", "923334845")),
				new Customer(4, "Gaman", "Gaman@gmail.com", Arrays.asList("923334448", "923334495")),
				new Customer(5, "Gagan", "Gagan@gmail.com", Arrays.asList("923334449", "923334495"))

		).collect(Collectors.toList());

	}
	
	public Stream<Customer> getCustStrem() {

		return Stream.of(new Customer(1, "Aman", "aman@gmail.com", Arrays.asList("923334444", "923334445")),
				new Customer(2, "Bman", "Bman@gmail.com", Arrays.asList("923334446", "923334449")),
				new Customer(3, "Chaman", "Chaman@gmail.com", Arrays.asList("923334447", "923334845")),
				new Customer(4, "Gaman", "Gaman@gmail.com", Arrays.asList("923334448", "923334495")),
				new Customer(5, "Gagan", "Gagan@gmail.com", Arrays.asList("923334449", "923334495"))

		);

	}
	
	public Customer getNullEmaillCustomer() {
		return new Customer(101, "john", null, Arrays.asList("923334444", "923334445"));
	}
	
	public Customer getCustomer() {
		return new Customer(101, "john", "aman@gmail.com", Arrays.asList("923334444", "923334445"));
	}

	public Optional<Customer> getCustomerByEmail(String email) throws Exception {
		List<Customer> allCustomers = this.getAllCustomer();
		
//		return Optional.ofNullable(allCustomers.stream()
//		.filter(customer -> customer.getEmail().equals(email)).findAny());
		return allCustomers.stream()
				.filter(customer -> customer.getEmail().equals(email)).findAny();	
	}
	
	public Map<Employees, Integer> getTreeMap() {
		Map<Employees, Integer> treeMap = new TreeMap<>();
		treeMap.put(new Employees(176, "Roshan", "A", 60000), 60);
		treeMap.put(new Employees(177, "Bikash", "B", 90000), 90);
		treeMap.put(new Employees(180, "Bimal", "E", 50000), 50);
		treeMap.put(new Employees(178, "Sourav", "C", 40000), 40);
		treeMap.put(new Employees(179, "Prakash", "D", 70000), 70);
		return treeMap;
	}
	
	
}