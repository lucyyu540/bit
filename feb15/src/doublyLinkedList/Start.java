package doublyLinkedList;

import java.util.Scanner;
/**
 * c: malloc and free -> heap mem
 * c++ new and delete -> heap mem
 * memory leak if free and delete are not declared
 * 
 * java and c#: garbage collector automatically cleans up heap mem
 * developer has minimal control over GC activities 
 * @author BIT_R34
 *
 */
public class Start {
	public static void test1() {
		DList list = new DList();
		for (int i = 1; i <= 10; i ++) {
			list.backInsert(String.valueOf(i));
		}
		Scanner in = new Scanner(System.in);
		System.out.println("************doubly linked list************");
		Loop : while(true) {
			list.selectNextAll();
			System.out.print(">> ");
			String input = in.nextLine();
			String[] arr = input.split(" ");
			switch(arr[0]) {
			case "finsert": list.frontInsert(arr[1]); break;
			case "binsert" : list.backInsert(arr[1]); break;
			case "selectprev" : list.selectPrevAll(); break;
			case "select" : System.out.println(list.select(arr[1])!=null? "found" : "not found"); break;
			case "fdelete" : list.frontDelete(); break;
			case "bdelete" : list.backDelete(); break;
			case "insert" : list.insert(arr[1], arr[2]); break;
			case "delete" : list.delete(arr[1]); break;
			case "exit" : break Loop;
			}
		}
		in.close();
		System.out.println("************doubly linked list************");
	}

	public static void main(String[] args) {
		test1();

	}

}

