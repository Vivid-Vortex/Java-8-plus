package com.java8.completableFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemoDrawback {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<Integer> future = service.submit(new Task());
		
		try {
			//get the task return value
			Integer result = future.get(); //blocking
			
			System.out.println("Result from the task is "+ result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}

class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return new Random().nextInt();
	}
	
}