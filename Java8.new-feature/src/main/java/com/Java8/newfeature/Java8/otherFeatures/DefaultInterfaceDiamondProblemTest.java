package com.Java8.newfeature.Java8.otherFeatures;

/**If any class in the hierarchy has a method with the same signature, then default methods become irrelevant.
 * The Object is the base class, so if we have equals(), hashCode() default methods in the interface, it will become irrelevant. 
 * That’s why for better clarity, interfaces are not allowed to have Object default methods.
 * 
 * In the example below, trying to override default toString from Object class, but getting compile time exception.
 * */
public class DefaultInterfaceDiamondProblemTest {
	
	@FunctionalInterface
	public interface Interface1 {
	 
	    void method1(String str);
	     
	    default void log(String str){
	        System.out.println("I1 logging::"+str);
	    }
	     
	    static void print(String str){
	        System.out.println("Printing "+str);
	    }
	     
//	    trying to override Object method gives compile-time error as
//	    "A default method cannot override a method from java.lang.Object"
	     
//	  default String toString(){
//	      return "i1";
//	  }
	     
	}
	
	@FunctionalInterface
	public interface Interface2 {
	 
	    void method2();
	     
	    default void log(String str){
	        System.out.println("I2 logging::"+str);
	    }
	 
	}
	
	public class MyClass implements Interface1, Interface2 {
		 
	    @Override
	    public void method2() {
	    }
	 
	    @Override
	    public void method1(String str) {
	    }
	    
	  //MyClass won't compile without having it's own log() implementation
		@Override
		public void log(String str) {
			
			
		}
	     
	}
}
