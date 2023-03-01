package com.Java8.newfeature.Java8.streams;

import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

import com.Java8.newfeature.Java8.dblayer.DbLayer;

public class ParalellStreamDemo {
	 
	public void testParallelStream() {
		long start = 0;
		long end = 0;
		
//		start = System.currentTimeMillis();
//		IntStream.range(1,10).forEach(System.out::println);
//		end = System.currentTimeMillis();
//		
//		System.out.print("Plain Stream took time : "+ (end - start));
//		
//		System.out.println("=====================================================");
//		start = System.currentTimeMillis(); System.out.println("Start Time :"+start);
//		IntStream.range(1, 100000000).parallel().forEach(System.out::println);
//		end = System.currentTimeMillis(); System.out.println("Start Time :"+end);
//		
//		System.out.print("Parallel Stream took time : "+ (end - start));
		
		
		IntStream.range(1, 10).forEach(x -> {
			Thread.currentThread().setName("Plain Thread "+x);
//			System.out.println("Thread :"+Thread.currentThread().getName() +" : "+x);
			System.out.println("Thread :"+Thread.currentThread().getId() +" : "+x);
		});
		
		IntStream.range(1, 10).parallel().forEach(x -> {
			Thread.currentThread().setName("parallel Thread "+x);
//			System.out.println("Thread :"+Thread.currentThread().getName() +" : "+x);
			System.out.println("Thread :"+Thread.currentThread().getId() +" : "+x);
		});
	}

}
