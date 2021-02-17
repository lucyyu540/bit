package stack;
import java.util.*;
public class StartStack {
	public static MyStack arrStack(Scanner in) {
		System.out.print("stack size > ");
		return new MyStack(Integer.parseInt(in.nextLine().trim()));
	}
	public static void test() {
		Scanner in = new Scanner(System.in);
		System.out.println("****************STACK TEST**********************");
		//MyStack stack = arrStack(in);
		StackLinkedList stack = new StackLinkedList();
		loop: while(true) {
			stack.printAll();
			System.out.print(">> ");
			String[] arr = in.nextLine().split(" ");
			switch(arr[0]) {
			case "push" : stack.push(arr[1]); break;
			case "pop" : System.out.println(stack.pop()); break;
			case "peek" : System.out.println(stack.peek()); break;
			case "clear" : stack.clear(); break;
			case "exit" : in.close(); break loop;
			}
		}
		System.out.println("****************TEST EXITING**********************");

	}

	public static void main(String[] args) {
		test();
	}

}
