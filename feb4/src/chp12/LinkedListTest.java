package chp12;
import java.util.*;
public class LinkedListTest {
	public static void main(String[] args) {
		List<String> ll = new LinkedList<String>();
		//ALL WORKS
		//List ll = new LinkedList<String>();
		//List<String> ll = new LinkedList();
		//List ll = new LinkedList();
		ll.add("s1"); ll.add("s2"); ll.add("s3");
		ll.set(0, "change");
		System.out.println("ll[0]: "+ ll.get(0));
		System.out.println("size: "+ ll.size());
		for (int i = 0; i < ll.size(); i ++) {
			System.out.print(ll.get(i)+ " ");
		}
	}
}
