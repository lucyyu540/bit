package chp12;
import java.util.*;
public class ArrayListTest {
	public static void main(String[] args) {
		//arraylist
		/*
		ArrayList l1 = new ArrayList();
		l1.add(10); l1.add(9); l1.add(8);
		l1.add(7); l1.add(6); l1.add(5);
		for (Iterator i = l1.iterator(); i.hasNext(); ) {
			System.out.println(i.next());
		}
		
		ArrayList l2 = new ArrayList(l1.subList(0, 5));
		System.out.println("1:"+ l1.toString());
		System.out.println("2:"+l2.toString());
		l2.add(4);
		System.out.println("1:"+ l1.toString());
		System.out.println("2:"+l2.toString());
		l2.add(1,100);
		System.out.println("1:"+ l1.toString());
		System.out.println("2:"+l2.toString());
		l2.set(1,200);
		System.out.println("1:"+ l1.toString());
		System.out.println("2:"+l2.toString());
		*/
		//1
		Scanner in = new Scanner(System.in);
		/*
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < 5; i ++) {
			System.out.printf("enter name #%d: ", i+1);
			names.add(in.next());
		}
		System.out.print("Search for name: ");
		int index = names.indexOf(in.next());
		if(index != -1) System.out.println("Name found at index " + index);
		else System.out.println("Name not found");
		
		//2
		Vector<Integer> v = new Vector<Integer>();
		int sum = 0, max = 0; 
		for (int i = 0; i < 5; i ++) {
			System.out.print("enter int: ");
			v.add(in.nextInt());
			sum += v.get(i);
			if(i==0) max = v.get(i);
			else max = Math.max(max, v.get(i));
		}
		System.out.println("max: " + max);
		System.out.println("sum: " + sum);
		*/
		Vector ve = new Vector ();
		while(true) {
			System.out.print("enter name: ");
			String name = in.next();
			if(name.equals("x")) break;
			ve.add(name);
		}
		int c= 0;
		for (Iterator i = ve.iterator(); i.hasNext();i.next()) {
			c++;
		}
		System.out.println("no. of names: " + c);
		in.close();
		
		
	}

}
