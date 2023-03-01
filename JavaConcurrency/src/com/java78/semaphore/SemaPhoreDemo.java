package com.java78.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;
/**
 * Semaphore - Whenever we want to restrict the usage of resources, which are in limited quantity,
 * semaphore is the way to handle such scenarios.
 * 
 * It's like slowing down the service or evading a bottle neck issue. Like a throttler in Apache camel.
 * */
public class SemaPhoreDemo {
	public static void main(String[] args) {
		//Semaphore will ensure that only 3 threads a time can access that particular piece of code in Task class.
		Semaphore semaphore = new Semaphore(3);
		
		ExecutorService executorService = Executors.newFixedThreadPool(50);
		IntStream.of(1000).forEach(i -> executorService.execute(new Task(semaphore)));
	}
}

class Task implements Runnable {
	
	Semaphore semaphore = null;
	
	public Task(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		someProcessor();
	}
	
	void someProcessor() {
		//Some Processing
		//In case if you don't' want to use try catch use semaphore.acquireUninterruptibly(); in place of semaphore.acquire();
		
		try {
			
			semaphore.acquire(2); // the number of permits you take, the number of permits you release.
			//IO call to the slow service
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//semaphore.release();
			semaphore.release(2); // the number of permits you take, the number of permits you release.
		}
		
		
	}
}