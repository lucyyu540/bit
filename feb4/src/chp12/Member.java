package chp12;
import java.util.*;
public class Member implements Comparable<Member>{
	private String name;
	private int id; 
	public Member(String s, int n) {
		this.name = s; 
		this.id = n;
	}
	public void print() {System.out.println("name: "+ this.name+ ", id: "+this.id);}
	public String getName() {return this.name;}
	public int getID() {return this.id;}
	@Override
	public int compareTo(Member o) { return this.id - o.getID(); }//acsending order
	
	/*public int compareTo(Member o) {
		return this.name.compareTo(o.getName());
	}*/
	/**public static void main(String[] args) {
		Set<Member> t = new TreeSet<Member>();
		t.add(new Member("Kim", 3));
		t.add(new Member("Park", 1));
		t.add(new Member("Lee",2));
		for (Member member : t) {member.print();}
	}*/
}
