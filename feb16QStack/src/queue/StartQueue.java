package queue;

import java.util.Scanner;

public class StartQueue {
	public static MyQueue arrQueue(Scanner in) {
		System.out.print("queue size > ");
		return new MyQueue(Integer.parseInt(in.nextLine().trim()));
	}

	public static void test() {
		Scanner in = new Scanner(System.in);
		System.out.println("****************QUEUE TEST**********************");
		//MyQueue q = arrQueue(in);
		QueueLinkedList q = new QueueLinkedList();
		loop: while(true) {
			q.printAll();
			System.out.print(">> ");
			String[] arr = in.nextLine().split(" ");
			switch(arr[0]) {
			case "push" : q.push(arr[1]); break;
			case "pop" : System.out.println(q.pop()); break;
			case "peek" : System.out.println(q.peek()); break;
			case "clear" : q.clear(); break;
			case "exit" : in.close(); break loop;
			}
		}
		System.out.println("****************TEST EXITING**********************");

	}

	public static void main(String[] args) {
		test();
	}


}
