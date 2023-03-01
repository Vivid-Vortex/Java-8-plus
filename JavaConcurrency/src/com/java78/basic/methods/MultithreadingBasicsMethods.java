package com.java78.basic.methods;

/** interrupt - one thread cannot stop the other thread. A thread can only request the other thread to stop. The request is made in the form of an interruption. Calling the interrupt() method on an instance of a Thread sets the interrupt status state as true on the instance.
	sleep - It will sleep that particular thread in between execution.
	join - When we join one thread, other thread will start once that thread finish execution. Later other threads can work concurrently.
	yield - causes the currently executing thread object to temporarily pause and allow other threads to execute.

 * */
public class MultithreadingBasicsMethods {
	public static void main(String args[]) {
//		testThreads();
//		testRunnable();
		testThreadGrouping();
	}

	private static void testThreadGrouping() {
		ThreadGroup tg1 = new ThreadGroup("Group A");
		Thread t1 = new Thread(tg1,new TestJoinMethodRunnable(),"one");     t1.start();
		Thread t2 = new Thread(tg1,new TestJoinMethodRunnable(),"two");     t2.start();
		Thread t3 = new Thread(tg1,new TestJoinMethodRunnable(),"three");    t3.start();
		tg1.setMaxPriority(Thread.NORM_PRIORITY);
		try {
//			tg1.interrupt();
			t1.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tg1.toString();
		
//		System.out.println("Thread Group Name: "+tg1.getName());
		tg1.list();  //This method prints information about the thread group to the standard output.
		
	}

	private static void testRunnable() {
		
		TestJoinMethodRunnable testJoinMethodRunnable = new TestJoinMethodRunnable();
		Thread th1 = new Thread(testJoinMethodRunnable);
		Thread th2 = new Thread(testJoinMethodRunnable);
		Thread th3 = new Thread(testJoinMethodRunnable);
		Thread th4 = new Thread(testJoinMethodRunnable);th4.setPriority(Thread.MAX_PRIORITY);
		
		th1.start();
		
		try {
			th1.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		th3.start();
		th4.start();
		
	}

	private static void testThreads() {
		TestJoinMethodThreads t1 = new TestJoinMethodThreads();
		TestJoinMethodThreads t2 = new TestJoinMethodThreads();
		TestJoinMethodThreads t3 = new TestJoinMethodThreads();
		t1.start();
		try {
			t1.join(); // With join, other threads t2 and t3 will wait till t1 finishes. Then t2 and t3 will work concurrently.
		} catch (Exception e) {
			System.out.println(e);
		}

		t2.start();
		t3.start();
	}
}

class TestJoinMethodThreads extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			String name = Thread.currentThread().getName();
			Thread.currentThread().setName(name+" "+i);
			System.out.println("name "+name);
		}
		Thread.currentThread().setName("Wonder Thread!!!");
		System.out.println("name "+Thread.currentThread().getName());
	}

	
}

class TestJoinMethodRunnable implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
		
		Thread.currentThread().setName("Wonder Runnable!!!");
		System.out.println("name "+Thread.currentThread().getName());
	}

	
}