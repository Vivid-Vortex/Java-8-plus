package com.Java8.newfeature.Java8.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.Java8.newfeature.Java8.beans.Customer;
import com.Java8.newfeature.Java8.beans.Employees;
import com.Java8.newfeature.Java8.dblayer.DbLayer;
/**
 * INTERMEDIATE OPERATION/METHODS ALWAYS RETURNS A NEW STREAM.
 *  Most of the times, these operations are lazy in nature, so they start producing new stream elements and send it to the next operation.
 *  Intermediate operations are never the final result producing operations. Commonly used intermediate operations are filter and map.
 *  
 *  terinal method = ava 8 Stream API operations that returns a result or produce a side effect. Once the terminal method is called on a stream, it consumes the stream and after that we can’t use stream. 
 *  Terminal operations are eager in nature i.e they process all the elements in the stream before returning the result.
 *  Commonly used terminal methods are forEach, toArray, min, max, findFirst, anyMatch, allMatch etc.
 *  YOU CAN IDENTIFY TERMINAL METHODS FROM THE RETURN TYPE, THEY WILL NEVER RETURN A STREAM.
 *  
 *  Short Circuiting Operations = An intermediate operation is called short circuiting, if it may produce finite stream for an infinite stream. For example limit() and skip() are two short circuiting intermediate operations.
 *  A terminal operation is called short circuiting, if it may terminate in finite time for infinite stream. For example anyMatch, allMatch, noneMatch, findFirst and findAny are short circuiting terminal operations.
 *  
 * */
@SuppressWarnings("unused")
public class StreamApis {
	
	DbLayer dbLayer;
	
	public StreamApis(DbLayer dbLayer) {
		this.dbLayer = dbLayer;
	}
  /**
   * Map is used for transforming the data. That is from one form to another. Such as 
   * 1. from lowerCase toUpperCase,
   * 2. Stream<Object> to Stream<int>, etc.
   * It is intermediate, so will return stream<T>
   */
	public void testMap() {
		System.out.println(dbLayer);
		List<Customer> custStrem = dbLayer.getCustStrema();
		
		//List of Customer to List of String -> Data Transformation
		List<String> emails = custStrem.stream().map(cust -> cust.getEmail()).collect(Collectors.toList());
		System.out.println("Fething list of emails from List of Customer into separate list as List<emails> :"+ emails);
		
		List<Integer> ids = custStrem.stream().map(id -> id.getId()).collect(Collectors.toList());
		System.out.println("\n\nFething list of ids from List of Customer into separate list as List<ids> :"+ ids);
		
		List<String> names = custStrem.stream().map(name -> name.getName()).collect(Collectors.toList());
		System.out.println("\n\nFething list of names from List of Customer into separate list as List<names> :"+ names);
		
		List<List<String>> phoneNumbersList = custStrem.stream().map(phoneNumber -> phoneNumber.getPhoneNumbers()).collect(Collectors.toList());
		System.out.println("\n\nFething list of phoneNumbers from List of Customer into separate list as List<List<phoneNumbers>> :"+ phoneNumbersList);
		
	}
	/**
	 * Map is used for transforming the data from one form to another. 
	 * Such as toUpperCase, from list to a single attribute (such as shown in testMap method) etc. But in contrast to Map, flatmap will take stream as an argument. So we must
	 * convert to stream before passing it to argument.
	 * Second things is that, it is used to convert or flatten list inside a particular objects which is also a part of list, to a single list, instead 
	 * of return List<List<Object>>.
	 */
	public void testFlatMap() {
		/*With flatmap you directly deal with the Object type. Regardless of the fact wheather it is 
		 * List<List<Customer>> or List<List<String>>. You don't need to first get the internal list 
		 * and loop through it to get the filterd object. 
		 * Insted you directly use flatmap and get the Customer and filter it directly using filter. That's it!!!
		 * 
		 * Case 1: Customer {List<String> phoneNumbers }. You have to select distinct phone number.
		 * In flatmap, you have to pass List which has to be converted to stream again at the end.
		 * So if you have any Objec which has List as it's variable, you pass that variable and use stream() at the end
		 * which will finally give you single value to operate on.
		 * 
		 * Case 2: You have List of List. Such as List<List<Customer>>. You have select customer with salary more than 70000.
		 * */
		List<Customer> custStrem = dbLayer.getCustStrema();

		//without flatmap
		//Also called one to one mapping
		List<List<String>> phoneNumbersList = custStrem.stream().map(phoneNumber -> phoneNumber.getPhoneNumbers()).collect(Collectors.toList());
		System.out.println("\n\nFething list of phoneNumbers from List of Customer into separate list as List<List<phoneNumbers>> :"+ phoneNumbersList);
		
		//with flatmap
		//Also called one to many mapping
		List<String> phoneNumbers = custStrem.stream().flatMap(phoneNumber -> phoneNumber.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println("\n\nFething list of phoneNumbers from List of Customer into separate list as List<phoneNumbers> :"+ phoneNumbers);
		
	}
	
	//If you have primitive type of list of list such as List<List<String>, then you can use .flatMap(List::stream) and if you have List<List<Customer>> then you can use any variable to flatten up using flatmap by doing
	
	//.flatMap(phoneNumber -> phoneNumber.getPhoneNumbers().stream())
	public void convertListOfListToSingleList() {
		/*With flatmap you directly deal with the Object type. Regardless of the fact wheather it is 
		 * List<List<Customer>> or List<List<String>>. You don't need to first get the internal list 
		 * and loop through it to get the filterd object. 
		 * Insted you directly use flatmap and get the Customer and filter it directly using filter. That's it!!!
		 * 
		 * Case 1: Customer {List<String> phoneNumbers }. You have to select distinct phone number.
		 * In flatmap, you have to pass List which has to be converted to stream again at the end.
		 * So if you have any Objec which has List as it's variable, you pass that variable and use stream() at the end
		 * which will finally give you single value to operate on.
		 * 
		 * Case 2: You have List of List. Such as List<List<Customer>>. You have select customer with salary more than 70000.
		 * */
		List<List<String>> strListOfList = new ArrayList<>();;
		List<String> strList = new ArrayList<>();
		strList.add("Apple");
		strList.add("Banana");
		strListOfList.add(strList);
		
		List<String> strList2 = new ArrayList<>();
		strList2.add("Apple2");
		strList2.add("Banana2");
		strListOfList.add(strList2);
		
		Stream<String> flatMap = strListOfList.stream().flatMap(List::stream);
		flatMap.map(str -> str.equals("Apple2")).findFirst();
		
		List<List<Employees>> empListOfList = new ArrayList<>();;
		List<Employees> empList = new ArrayList<>();
		empList.add(new Employees(0, null, null, 0));
		empList.add(new Employees(0, null, null, 0));
		empListOfList.add(empList);
		
		List<Employees> empList2 = new ArrayList<>();
		empList2.add(new Employees(0, null, null, 0));
		empList2.add(new Employees(0, null, null, 0));
		empListOfList.add(empList2);
		
		Stream<Employees> flatMap2 = empListOfList.stream().flatMap(List::stream);
		List<Employees> collect = flatMap2.filter(emp -> emp.getName().equals("Aman")).collect(Collectors.toList());
		
		
		
		
		
	}
	
	
	
	public void testMapToObj() {
		
		List<Customer> collect = IntStream.rangeClosed(1, 50)
//		.peek(null)
		.peek(i -> System.out.println("Processing count : " + i))
		.mapToObj(i -> new Customer(i, "", null,null )) //It will map int to Customer Object
		.collect(Collectors.toList());
		
//		IntStream.range(0, 0) //In this last digit will be excluded but in rangeClose last value will be included.
//		IntStream.rangeClosed(1, 50)
////		.peek(null)
//		.peek(i -> System.out.println("Processing count : " + i)).mapToLong( i -> i);
//		.mapToObj(i -> new Customer(i, "", null,null )) //It will map int to Customer Object
//		.collect(Collectors.toList());
	}
	/**
	 * Map is used for transforming the data. That is from one form to another. Such as Stream<Object> to Stream<int>.
	 * Reduce is used to combine data. Such as combine stream<int> and produce the sum result.
	 */
	public void testMapReduce() {
		List<Integer> numbers = Arrays.asList(3,7,8,1,5,9);
		List<String> numbersStr = Arrays.asList("3","7","8","1","5","9");
		
//		System.out.println(numbers.stream().filter(p -> Integer.valueOf(p) > 5).reduce(0, (a,b) -> a +b));;
//		System.out.println(numbersStr.stream().map(p -> Integer.valueOf(p)).reduce(0, (a,b) -> a +b));;
//		System.out.println(numbers.stream().reduce(0, (a,b) -> a+b));
//		System.out.println(numbersStr.stream().reduce((a,b) -> a +b).get());
//		
//		System.out.println(numbersStr.stream().map(str -> Integer.parseInt(str)).mapToInt(i -> i).sum());
//		System.out.println(numbers.stream().mapToInt(i -> i).sum());
//		Optional<Integer> reduceSum = numbers.stream().reduce(Integer::sum);
//		System.out.println(reduceSum.isPresent() ? reduceSum.get() : "");
//		
//		Integer mulitpliedNums = numbers.stream().reduce(1,(a,b) -> a*b);
//		System.out.println(mulitpliedNums);

//		//To find the max value out of all the integers.
//		Integer mulitpliedNums = numbers.stream().reduce(1,(a,b) -> a > b ? a : b);
//		System.out.println(mulitpliedNums);
	
//		Optional<Integer> maxValueUsingAccumulator = numbers.stream().reduce(Integer::max);
//		System.out.println(maxValueUsingAccumulator.get());
	
//		List<String> toFindLongestString = Arrays.asList("coreJava", "Spring", "Hibernate");
//		String string = toFindLongestString.stream()
//				.reduce((word1,word2) -> word1.length()> word2.length() ? word1 : word2)
//				.get();
//		System.out.println(string);
	
//		double doubleAvgSal = dbLayer.getEmployees().stream()
//					.filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
//					.map(employee -> employee.getSalary())
//					.mapToDouble(i -> i)
//					.average().getAsDouble();	
//		System.out.println(doubleAvgSal);
	
//		 long reduce = dbLayer.getEmployees().stream()
//						.filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
//						.map(employee -> employee.getSalary())
//						.mapToLong(i -> i)
//						.reduce(1, (a,b) -> a > b ? a : b);
//		 System.out.println(reduce);
		
		
//		double sumSalary = dbLayer.getEmployees().stream()
//				.filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
//				.map(employee -> employee.getSalary())
//				.mapToDouble(i -> i)
//				.sum();
//		System.out.println(sumSalary);
		
		
	}
	
	public void testPureOptionalWithoutStream() throws FileNotFoundException {
		Customer customer = dbLayer.getNullEmaillCustomer();
		Customer customerWithAllNonEmptyFields = dbLayer.getCustomer();
		//Three ways to create Optional Object
		//1. empty 2. of 3. ofNullable
		
		//It will simply create an Optional object and return
//		Optional<Object> emptyOptional = Optional.empty();
//		System.out.println("empty Optionlal :"+emptyOptional);
		
//		try {
//			//It will check null check internally
//			Optional<String> emailOptonal = Optional.of(customer.getEmail());
//			System.out.println("\n\n empty Optionlal :"+emailOptonal);
//		} catch (Exception e) {
//			System.out.println("Excepton Occured...");
//			writeLogsToLogsFile(e);
//		}
		
		//If we know the object can be null. So use ofNullable
//		Optional<String> nullableEmail = Optional.ofNullable(customer.getEmail());
//		System.out.println("\n\n nullable Email :"+nullableEmail);
		
//		Optional<String> nonNullableEmail = Optional.ofNullable(customerWithAllNonEmptyFields.getEmail());
//		System.out.println("\n\n nonNullable Email :"+nonNullableEmail);
		
		//For fetching values out of  Optional object. We must use get.
		//But make sure to check for empty or non empty. Before getting the value. Otherwise it will throw java.util.NoSuchElementException
		
		
		//It will throw java.util.NoSuchElementException
//		try {
//			System.out.println("\n\n nullable Email :"+Optional.ofNullable(customer.getEmail()).get());
//		} catch (Exception e) {
//			System.out.println("Excepton Occured...");
//			writeLogsToLogsFile(e);
//		}
		
		//It wont throw java.util.NoSuchElementException
//		Optional<String> nullableEmail2 = Optional.ofNullable(customer.getEmail());
//		if(nullableEmail2.isPresent()) {
//			System.out.println("\n\n nullable Email :"+nullableEmail2.get());
//		}
		
		//Sending default value if Optonal is empty
//		Optional<String> nullableEmail3 = Optional.ofNullable(customer.getEmail());
//		System.out.println("\n\n nullable Email :"+nullableEmail3.orElse("defaultemail@gmail.com"));
		
//		Optional<String> nonNullableEmail2 = Optional.ofNullable(customerWithAllNonEmptyFields.getEmail());
//		System.out.println("\n\n customerWithAllNonEmptyFields Email :"+nonNullableEmail2.orElse("defaultemail@gmail.com"));
		
//		Optional<String> nullableEmail4 = Optional.ofNullable(customer.getEmail());
//		System.out.println("\n\n customerWithAllNonEmptyFields Email :"+nullableEmail4.orElseThrow(() -> new IllegalArgumentException("email not present")));
		
//		Optional<String> nullableEmail5 = Optional.ofNullable(customer.getEmail());
//		System.out.println("\n\n customerWithAllNonEmptyFields Email :"+nullableEmail5.map(String::toUpperCase).orElseGet(()-> "defaultemail@gmail.com"));
		
//		Optional<String> nonNullableEmail3 = Optional.ofNullable(customerWithAllNonEmptyFields.getEmail());
//		System.out.println("\n\n customerWithAllNonEmptyFields Email :"+nonNullableEmail3.map(String::toUpperCase).orElseGet(()-> "defaultemail@gmail.com"));

	}
	
	public void testOptionalwithStream() throws Exception {
		Customer customer = dbLayer.getNullEmaillCustomer();
		Customer customerWithAllNonEmptyFields = dbLayer.getCustomer();
		//It will throw exception
//		Customer cust = dbLayer.getCustomerByEmail("pqr");
		Optional<Customer> cust = dbLayer.getCustomerByEmail("Bman@gmail.com");
		if (cust.isPresent()) {
			System.out.println(cust.get());
		}
//		System.out.println(cust);
	}
	
	
	public void writeLogsToLogsFile(Exception e) throws FileNotFoundException {
		File file = new File("D:/logs");
		PrintWriter printWriter = new PrintWriter(file );
		printWriter.append("Excepton Occured :"+e);
		printWriter.close();
	}
	
	public void sortListUsingStreamApi() {
		List<Customer> allCustomer = dbLayer.getAllCustomer();
		
		Map<String, Customer> collect = allCustomer
				.stream()
//				.sorted(Comparator.comparing(Customer::getId)) // no use of sorting list and put it into map coz map will again sort using hash
				.collect(Collectors.toMap(Customer::getName, i -> i));
//		System.out.println(collect);
		
//				allCustomer
//				.stream()
//				.sorted(Comparator.comparing(Customer::getId))
//				.forEach(System.out::println);
		
				
				HashMap<Integer, Customer> collect2 = allCustomer
				.stream()
				.collect(Collectors.toMap(Customer::getId, i -> i))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n) -> o,HashMap::new));
//				System.out.println(collect2);
				
				HashMap<Integer, Customer> collect3 = allCustomer
						.stream()
						.collect(Collectors.toMap(Customer::getId, i -> i))
						.entrySet().stream()
						.sorted(Map.Entry.comparingByValue(Comparator.comparing(Customer::getName)))
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n) -> o,HashMap::new));
//				System.out.println(collect3);
				
				//Reverseorder
				HashMap<Integer, Customer> collect4 = allCustomer
				.stream()
				.collect(Collectors.toMap(Customer::getId, i -> i))
				.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue(Comparator.comparing(Customer::getName))))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n) -> o,HashMap::new));
		System.out.println(collect3); // Please note that after reversing you are putting it in map and map doesn't gurantee order so final map will not be sorted
				
				
				
		
	}
	public void sortMapUsingStreamApi() {
		/** If comparing by Custom type as either key or value, pass below as argument(arg) in .sorted(Map.Entry.comparingByKey(arg))
		 * .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees::getGrade))) 
		 * or .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees::getGrade).reversed())) for reverse order.
		 * 
		 * If comparing by primitive type as either  key or value, no need to pass comparator in arg as .sorted(Map.Entry.comparingByKey(arg)).
		 * Rather we can use it dirctly without passing anything inside comparingByKey() or ComparingByValue().
		 * 
		 * 
		 * */
		/**Normal primitive type key,value sorting*/
		Map<String,Integer> map = new HashMap<>();
		map.put("eight",8);
		map.put("four", 4);
		Map<Customer, String> allCustomerAsMap = dbLayer.getAllCustomerAsMap();
//		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
//		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
				
		map.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		/**Sorting using Treemap's comparator constructor using lambda expresson*/	
		Map<Employees, Integer> treeMapUsingLambdaExp = new TreeMap<>((o1,o2) -> (int) (o1.getSalary() - o2.getSalary()));
		treeMapUsingLambdaExp.put(new Employees(176, "Roshan", "A", 60000), 60);
		treeMapUsingLambdaExp.put(new Employees(177, "Bikash", "B", 90000), 90);
		treeMapUsingLambdaExp.put(new Employees(180, "Bimal", "E", 50000), 50);
		treeMapUsingLambdaExp.put(new Employees(178, "Sourav", "C", 40000), 40);
		treeMapUsingLambdaExp.put(new Employees(179, "Prakash", "D", 70000), 70);
//		
//		System.out.println("Tree Map using Lambda Expression :"+treeMapUsingLambdaExp);
		
		/**Sorting using Treemap's comparator constructor using stream api*/
		Map<Employees, Integer> treeMapUsingStreamApi = new HashMap<>();
		treeMapUsingStreamApi.put(new Employees(176, "Roshan", "A", 60000), 60);
		treeMapUsingStreamApi.put(new Employees(177, "Bikash", "B", 90000), 90);
		treeMapUsingStreamApi.put(new Employees(180, "Bimal", "E", 50000), 50);
		treeMapUsingStreamApi.put(new Employees(178, "Sourav", "C", 40000), 40);
		treeMapUsingStreamApi.put(new Employees(179, "Prakash", "D", 70000), 70);
		//Sorting in asc by salary
//		treeMapUsingStreamApi.entrySet().stream()
//								.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees::getSalary)))
//								.forEach(System.out::println);
		//Sorting in asc by grade
//		treeMapUsingStreamApi.entrySet().stream()
//		.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees::getGrade)))
//		.forEach(System.out::println);
		
		//Descending order
//		treeMapUsingStreamApi.entrySet().stream()
//		.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees::getGrade).reversed()))
//		.forEach(System.out::println);
		
		//For comparing using value. As the value contains primitive type, so we must use below implementation
		treeMapUsingStreamApi.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.forEach(System.out::println);
		
	}
	
	public void sortMapUsingTraditionalApproach() {
		Map<Customer, String> allCustomerAsMap = dbLayer.getAllCustomerAsMap();
		
		//1. Convert the map to a list as Collections.sort(List) always accept list.
		Set<Entry<Customer, String>> entrySet = allCustomerAsMap.entrySet();
		List<Entry<Customer, String>> entriesList = new ArrayList<>(entrySet);
//		entriesList.forEach(System.out::println);
		/**Sorting based on key of Map. Sorting based on id of Customer, which is used as a key. We can sort using any properties of Customer*/
//		Collections.sort(entriesList, (o1,o2) -> o1.getKey().getId() - o2.getKey().getId());
		System.out.println("Sorting based on Map key :"+entriesList+"\n\n\n\n");
		/**Sorting based on value of Map.*/
		Collections.sort(entriesList, (o1,o2) -> o1.getValue().compareTo(o2.getValue()));
	
		/**Sorting using Treemap's comparator constructor*/	
		System.out.println("Sorting based on Map value :"+entriesList);
		
		Map<Customer, String> allCustomerAsMapCutomObjs = dbLayer.getAllCustomerAsMap();
		
		Map<Employees, Integer> treeMapUsingAnonymousImplementation = new TreeMap<>(new Comparator<Employees>() {

			@Override
			public int compare(Employees o1, Employees o2) {
				
				return (int) (o1.getSalary() - o2.getSalary());
			}	
		});
		
		treeMapUsingAnonymousImplementation.put(new Employees(176, "Roshan", "A", 60000), 60);
		treeMapUsingAnonymousImplementation.put(new Employees(177, "Bikash", "B", 90000), 90);
		treeMapUsingAnonymousImplementation.put(new Employees(180, "Bimal", "E", 50000), 50);
		treeMapUsingAnonymousImplementation.put(new Employees(178, "Sourav", "C", 40000), 40);
		treeMapUsingAnonymousImplementation.put(new Employees(179, "Prakash", "D", 70000), 70);
		
		System.out.println("Employees Map from anonymus Impl :"+treeMapUsingAnonymousImplementation);
		
		
	}
	
	public void testConvertListToMap() {
		List<Customer> allCustomer = dbLayer.getAllCustomer();
		Map<String, Integer> mapCollecter = allCustomer.stream().collect(Collectors.toMap(Customer::getName, Customer::getId));
		
//		System.out.println(mapCollecter);
		
		mapCollecter.entrySet().stream().collect(Collectors.toList()).forEach(System.out::println);;
		
		
		ArrayList<Entry<String, Integer>> collect2 = mapCollecter.entrySet().stream().collect(Collectors.toCollection(ArrayList::new));
		
		//Type 2 with object as key or value
		Map<String, Customer> mapCollecterType2 = allCustomer.stream().collect(Collectors.toMap(Customer::getName, i -> i));
		
		
	}
	
	public void testConvertListToArray() {
//		int[] array = list.stream().mapToInt(i->i).toArray();
	}
	public void testConvertMapToList() {
		
		Map<Integer, List<String>> newMap = new HashMap<>();

		List<String> firstName = new ArrayList();
		firstName.add(0, "Jon");
		firstName.add(1, "Johnson");
		List<String> secondName = new ArrayList();
		secondName.add(0, "Peter");
		secondName.add(1, "Malone");

		// Insert elements into the Map
		newMap.put(1, firstName);
		newMap.put(2, secondName);
		
		Collection<List<String>> values = newMap.values();
		
		
		////////////////////
		
		Map<List<String>,Integer> newMap2 = new HashMap<>();

		List<String> firstName1 = new ArrayList();
		firstName.add(0, "Jon");
		firstName.add(1, "Johnson");
		List<String> secondName2 = new ArrayList();
		secondName.add(0, "Peter");
		secondName.add(1, "Malone");

		// Insert elements into the Map
		newMap2.put(firstName1,1);
		newMap2.put(secondName2,2);
		
//		 Set<List<String>> keySet = newMap2.keySet();
//		 List<List<String>> listoflist = keySet.stream().collect(Collectors.toList());
//		 Stream<String> flatMap = listoflist.stream().flatMap(List::stream);
		 
		 flatMap.forEach(System.out::println);
		 
		 //type two where list in map's key - do in one line
		 Stream<String> flatMap = newMap2.keySet().stream().flatMap(List::stream);
		 
		 
	}
	
}
