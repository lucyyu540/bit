package ch12;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println("string equals string: " + s1.equals(s2));
		Person p1 = new Person("lucy",1);
		Person p2 = new Person("lucy", 1);
		System.out.println("obj equals obj: " +p1.equals(p2));
		Set set = new HashSet();
		set.add("p1");
		set.add("p2");
		System.out.println(set);
	}

}
class Person {
	String name; int age;
	public Person(String s, int i) {
		this.name = s;
		this.age = i;
	}
}
