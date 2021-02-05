package ch12;

public class ThreadTest {

	public static void main(String[] args) {
		Thread thread = new Thread();
		thread.start();
		Counter c = new Counter();
		new MyThread(c).start();
		new MyThread(c).start();
		new MyThread(c).start();
		new MyThread(c).start();
		
		/*
		Thread myRunnableA = new Thread(new MyRunnable("A"));
		Thread myRunnableB = new Thread(new MyRunnable("B"));
		myRunnableA.start();
		myRunnableB.start();
		*/
	}

}
class Counter {
	private int value = 0;
	public synchronized void incr() {this.value++;}
	public synchronized void decr() {this.value--;}
	public synchronized void print() {System.out.println(this.value);}
}
class MyThread extends Thread{
	Counter sharedCounter;
	public MyThread(Counter c) {
		this.sharedCounter = c;
	}
	public void run() {
		for (int i = 0 ; i <2000;i++) {
			sharedCounter.incr();
			sharedCounter.decr();
			if(i%40 == 0) sharedCounter.print();
			try {
				sleep((int) Math.random()*2);
			}
			catch(Exception e) {}
			
		}
		
	}
}
class MyRunnable implements Runnable {
	private String name;
	public MyRunnable(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("MyRunnable");
		for (int i = 0 ; i < 5; i ++) {
			System.out.println(i+ " "+name);
		}
		
	}
	
}
