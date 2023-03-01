import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.jupiter.api.Test;

import sun.tools.jar.resources.jar;

public class DPDemo1 {
	
//	public Integer fib(int n) {
//		
//		if(n <= 2) return 1;
//		
//		return fib(n-1) + fib(n-2);
//	}
	
public Integer fib(int n) {
		
		if(n <= 2) return 1;
		
		int n1 = fib(n-1) + fib(n-2);
		
//		System.out.println(n1);
		return n1;
	}
	
	static int fibDP(int n)
	{
		/* Declare an array to store Fibonacci numbers. */
		int f[] = new int[n+2]; // 1 extra to handle case, n = 0
		int i;
		  
		/* 0th and 1st number of the series are 0 and 1*/
		f[0] = 0;
		f[1] = 1;
		 
		for (i = 2; i <= n; i++)
		{
		   /* Add the previous 2 numbers in the series
		     and store it */
		    f[i] = f[i-1] + f[i-2];
		}
		  
	return f[n];
	}

public void dib(int n) {
	if(n<=1) return;
	
	dib(n -1)
	
	
}
	public void foo(int n) {
		if(n <= 1) return;
		System.out.println(n);
		foo(n-1);
	}
	
	@Test
	void test() {
//		fib(6);
//		System.out.println(fib(6));
		
//		System.out.println(fib(7));
//		
//		System.out.println(fib(8));
//		
//		System.out.println(fib(50));
		
	}
	
@Test
	void testFoo() {
//		foo(5);
//		System.out.println(foo(5));
		
		System.out.println(fibDP(50));
	}


 void matchStr() {
		char a[] = {'b','a','n','a','p','p','l','e'};
		
//		char a[] = {'a','p','p','l','e'};
		
		char b[] = {'a','p','p','l','e'};
		
//		for(int i =0; i < a.length; i++) {
//			System.out.println(i);
//			if(i >= 4) {
//				i = -1;
//			}
//			Thread.sleep(600);
//		}
		
		boolean match = false;
		int jLastLoc = 0;
		int j = 0;
		for(int i = 0; i < b.length; i++) {
			
			for(; j< a.length; j++) {
				if(b[i] == a[j]) {
					match = true;
					jLastLoc = j;
					break;
				} else {
					match = false;
					break;
				}
			}
			
			if(match == true) {
				j = jLastLoc + 1;
			} else {
				j =0;
				break;
			}
		}
		
		if(match == true) {
			System.out.println("String matches!!!");
		} else {
			System.out.println("String do not matches!!!");
		}
 }
 
 
public static boolean strMatch(String mainStr, String strToMatch) {
	 char[] a = mainStr.toCharArray();
	 char[] b = strToMatch.toCharArray();
	 
		int aStart = 0;
				int aEnd = 0;
				
						int 	bEnd = 0;
				
						boolean match = false;
						int bCount = 0;
						int aCount = 0;
				
			while(aCount < a.length && bCount < b.length) {
				if (a.length - aStart > b.length) {
					if (a[aEnd] == b[bEnd]) {
						aEnd++;
						bEnd++;
						match = true;
						bCount++;
					} else {
						if (match == true && bEnd != 0) {
							aStart = aEnd;
							bEnd = 0;
						} else {
							aStart++;
							aEnd++;
						}

						if (bEnd != 0)
							bEnd = 0;

						bCount = 0;
						match = false;
					}
					aCount++;
				} else {
					match = false;
				}
			}
			
			return match;
	 
 }
public static void main(String[] args) throws InterruptedException {
	
	String mainString = "bananaapple";
	String strToMatch = "appleo";
	
	boolean strMatch = strMatch(mainString,strToMatch);
	
	if(strMatch == true)
		System.out.println("String Matches!!!");
	else 
		System.out.println("String do not matches...");
	
}
}
