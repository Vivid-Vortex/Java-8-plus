package com.Java8.newfeature.Java8.restcontrollers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Java8.newfeature.Java8.beans.Customer;

@RestController
public class TestValidationUsingRest {
	
	
	@PostMapping("/send")
	@ResponseBody Customer getValidCustomer(@Valid @RequestBody Customer customer) {
		
		return new Customer(2, "Aman", "aman@gmail.com", Arrays.asList("923334444", "923334445"));

	}
	
	@GetMapping("/get")
	String getTest() {
		boolean b = true;
		if(b)
			return "Transaction failed!!!";
		return "hello world";
	}
	
	@GetMapping("/get2")
	String getTest2() {
		
		return "hello world";
	}
}
