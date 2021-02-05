package ch12;
import java.util.*;
public class Program {
	private Set<Member> members = new TreeSet<Member>();
	/*1*/public void signUp(String name, int id) {
		if(members.add(new Member(name, id))) System.out.println("sign up succesful");
		else System.out.println("id already exists");
	}
	/*2*/public void deleteMember(int id) {
		Member temp = new Member("", id);
		if(members.remove(temp)) System.out.println("succesfully deleted");
		else System.out.println("member not found");
	}
	/*3*/public void print() { for(Member mem : this.members) {mem.print();} }
	public void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("***********");
		System.out.println("1) sign up\n2) delete member\n3) print all\n4) exit");
		System.out.println("***********");
		int menu = in.nextInt();
		if(menu == 1) {
			System.out.print("name: ");
			String name = in.next();
			System.out.print("id: ");
			int id = in.nextInt();
			this.signUp(name,id);
		}
		else if(menu == 2) {
			System.out.print("id: ");
			int id = in.nextInt();
			this.deleteMember(id);
		}
		else if (menu == 3) this.print();
		else if (menu ==4) System.exit(0);
		else System.out.println("invalid input");
	}
	public static void main(String[] args) {
		Program program = new Program();
		while(true) {program.menu();}
	}
}
class Member implements Comparable<Member>{
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
	public boolean equals(Member o) {
		if(this.id == o.getID()) return true;
		else return false;
	}
	public int hashCode() {
		return ((Integer)this.id).hashCode();
	}
}