package com.Java8.newfeature.Java78.resurssion;

public class ResurssionTest {

	public static void main(String[] args) {
//		sayHiDecrementInFunctionItself(6);
//		countBackwards(14);
		
		//5! = 5 * (4 * 3 * 2 * 1) = 120
//				System.out.println(factorial(5));
		System.out.println(fibonacci(6));

	}
	
	public static void sayHi(int n) {
		if(n == 0) {
			System.out.println("Done!");
		} else {
			System.out.println("hi");
			n--;
			sayHi(n);
		}	
		
	}
	
	public static void sayHiDecrementInFunctionItself(int n) {
		if(n == 0) {
			System.out.println("Done!");
		} else {
			System.out.println("hi");
			
			sayHiDecrementInFunctionItself(n-1);
		}	
		
	}
	
	public static void countBackwards(int n) {
		if(n == 0) {
			System.out.println("Done!");
		} else {
			System.out.println(n);
			n--;
			countBackwards(n);
		}
	}
	
	public static int factorial(int n) {
		if(n == 1) {
			System.out.println("factorial(" + n + ") = 1");
			return 1;
		} else {
			System.out.println("factorial(" + n + ") = " + n + " * factorial(" + (n - 1) + ")");
			return n * factorial(n - 1);
		}
	}
	
	static final int max = 100000;
	   static int[] fib = new int[max];
	static int fibonacci(int num) { //6
		
        if (num == 0) 
        	return 0;
        if (num == 1) 
        	return 1;

        if (fib[num] != 0) {
            return fib[num];    
        }
        
        System.out.println("fibonacci(" + num + ") = " + "fibonacci(" +(num - 1) + ") + " +" fibonacci(" + (num - 2) + ")");
//        System.out.println(fib[num]);
        fib[num] = fibonacci(num - 2);
        System.out.println(num);
        System.out.println(fib[num]);
        return fib[num];
    }


}
