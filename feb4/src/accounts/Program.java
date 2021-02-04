package accounts;
import java.util.*;
public class Program {
	private ArrayList<User> users = new ArrayList<User>();
	private boolean exit = false;
	public void addUser(String username, String pw) {this.users.add(new User(username, pw));}
	public void print() {
		for(User u : this.users) {System.out.println(u.getUsername());}
	}
	public boolean getExit() {return this.exit;}
	public void menu(Scanner in) {
		System.out.println("MENU:\n1) sign up\n2) print all users\n3) exit");
		int input = in.nextInt();
		if(input==3) this.exit=true;
		else if(input == 2) this.print();
		else if(input == 1) {
			System.out.print("username: ");
			String username = in.next();
			System.out.print("password: ");
			String pw = in.next();
			this.addUser(username, pw);
			System.out.println("new user added");
		}
	}
	public static void main(String[] args) {
		Program program = new Program();
		Scanner in = new Scanner(System.in);
		while(!program.getExit()) {program.menu(in);}
		in.close();
	}
}
