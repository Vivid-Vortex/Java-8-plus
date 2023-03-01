package com.Java8.newfeature.Java78.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExecuterTaskUsingCallable implements Callable<String> 
{
    private final String name;
 
    public ExecuterTaskUsingCallable(String name) {
        this.name = name;
    }
 
    @Override
    public String call() 
    {
        try {
			System.out.printf("%s: Staring\n", this.name);
 
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
//            TimeUnit.SECONDS.sleep(duration);
 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "SUCCESS";
    }
    
    public static void main(String[] args) {
    	ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(2);
    	 
        List<ExecuterTaskUsingCallable> taskList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ExecuterTaskUsingCallable task = new ExecuterTaskUsingCallable("Task-" + i);
            taskList.add(task);
        }
         
        //Execute all tasks and get reference to Future objects
        List<Future<String>> resultList = null;
 
//        try {
//            resultList = executor.invokeAll(taskList);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 
        executor.shutdown();
 
        System.out.println("\n========Printing the results======");
         
//        for (int i = 0; i < resultList.size(); i++) {
//            Future<String> future = resultList.get(i);
//            try {
//                String result = future.get();
////                System.out.println(result.getName() + ": " + result.getTimestamp());
//                System.out.println("Result Is :"+result);
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        
        //Using For each
        for (Future<String> future : resultList) {
        	try {
                String result = future.get();
//                System.out.println(result.getName() + ": " + result.getTimestamp());
                System.out.println("Result Is :"+result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
	}
    
}
