package stack;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	/*
	 * palindrome
	 */
	public static String reverse(Scanner in) {
		System.out.print("enter string: ");
		String s = in.nextLine().trim();
		StackLinkedList stack = new StackLinkedList();
		for (Character c : s.toCharArray()) {
			stack.push(c);
		}
		String res = "";
		while(stack.peek()!=null) {
			res+=stack.pop();
		}
		System.out.println(res);
		return res;
	}
	/**
	 * digit to binary code
	 * @param in
	 */
	public static void dectobinary(Scanner in) {
		System.out.print("enter num: ");
		Integer data = Integer.parseInt(in.nextLine().trim());
		StackLinkedList stack = new StackLinkedList();
		while(data>=2) {
			stack.push(data%2);
			data /= 2;
		}
		stack.push(data);
		while(stack.peek()!=null) {
			System.out.print(stack.pop() + " ");
		}
	}
	/**
	 * equation priority sorting stuff
	 * @param in
	 * @return
	 */
	public static String postfix(Scanner in) {
		System.out.print("enter eq: ");
		String s = in.nextLine().trim();
		String res = "";
		StackLinkedList stack = new StackLinkedList();
		for(Character c : s.toCharArray()) {
			if (c == ')') res += " "+stack.pop();
			else if(c == '+' || c == '-' || c == '*' || c == '/') {
				res+= " ";
				stack.push(c); 
			}
			else if (Character.isLetterOrDigit(c))res+=c;
		}
		return res+=" "+stack.pop();
	}
	public static int fix(Scanner in) {
		String[] arr = postfix(in).trim().split(" ");
		System.out.println(Arrays.toString(arr));
		StackLinkedList stack = new StackLinkedList();
		for(String s : arr) {
			try {
				stack.push(Integer.parseInt(s));
			}
			catch(Exception e) {
				if(s.equals("+")) stack.push((int)stack.pop()+(int)stack.pop());
				else if (s.equals("-")) stack.push(-(int)stack.pop()+(int)stack.pop());
				else if (s.equals("*")) stack.push((int)stack.pop()*(int)stack.pop());
				else if (s.equals("/")) stack.push((1/(int)stack.pop())*(int)stack.pop());
			}
		}
		System.out.println(stack.peek());
		return (int)stack.pop();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//reverse(in);
		//dectobinary(in);
		fix(in);
		in.close();

	}

}
