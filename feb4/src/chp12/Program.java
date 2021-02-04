package chp12;
import java.util.*;
public class Program {
	private Set<Member> members = new TreeSet<Member>();
	/*1*/public void signUp(String name, int id) { 
		for (Member m : this.members) {
			if(m.getID()==id) {
				System.out.println("id already exists");
				return;
			}
		}
		members.add(new Member(name, id));
		System.out.println("sign up succesful");
	}
	/*2*/public void deleteMember(String name, int id) {
		for (Member m : members) {
			if(m.getName().equals(name) && m.getID()==id) {
				members.remove(m);
				System.out.println("succesfully deleted");
				return;
			}
		}
		System.out.println("member not found");
	}
	/*3*/public void print() { for(Member mem : this.members) {mem.print();} }
	public void menu(Scanner in) {
		System.out.println("***********");
		System.out.println("1) sign up\n2) delete member\n3) print all\n4) exit");
		System.out.println("***********");
		int menu = in.nextInt();
		if(menu == 1 || menu == 2) {
			System.out.print("name: ");
			String name = in.next();
			System.out.print("id: ");
			int id = in.nextInt();
			if(menu == 1) this.signUp(name,id);
			else this.deleteMember(name,id);
		}
		else if (menu == 3) this.print();
		else if (menu ==4) System.exit(0);
		else System.out.println("invalid input");
	}
	public static void main(String[] args) {
		Program program = new Program();
		Scanner in = new Scanner(System.in);
		while(true) {program.menu(in);}
	}
}
