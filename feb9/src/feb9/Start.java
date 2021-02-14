package feb9;
import java.util.Scanner;

public class Start {
	public static void main(String[] args) {
		App app = App.getInstance();
		app.run();
		app.exit();
	}

}
class App {
	/*SINGLETON*/
	private App() { init(); }
	private static App singleton = new App();//only instantiated ONCE
	public static App getInstance() { return singleton; } //public access this instance
	/*********************************************************/
	private Manager manager = Manager.getInstance();
	public void init() { BitGlobal.logo(); }
	public void run() {
		while (true) {
			manager.selectAll();
			switch(BitGlobal.menu()) {
			case 1: //insert
				manager.insert();
				break;
			case 2: //select
				manager.select();
				break;
			case 3: //update
				manager.update();
				break;
			case 4: //delete
				manager.delete();
				break;
			case 5: return;
			}
			BitGlobal.pause();
				
		}
		
	}
	public void exit() { BitGlobal.ending(); }
	
}
class Manager{
	//singleton
	private Manager() {
		arr = new BitArray(inputMax());
	}
	private static Manager singleton = new Manager();
	public static Manager getInstance() { return singleton;}
	//field
	private BitArray arr;
	//methods
	public int inputMax() {
		return BitGlobal.inputNumber("Enter number");
	}
	public void insert() {
		try {
			int number = BitGlobal.inputNumber("Enter id");
			String name = BitGlobal.inputString("Enter name");
			String phone = BitGlobal.inputString("Enter contact info");
			char sex = BitGlobal.inputString("Enter sex").charAt(0);
			arr.insert(new Member(number, name, phone, sex));
			System.out.println("Insert successful");
		}
		catch(Exception e) {
			System.out.println("Insert failed: "+e.getMessage());
		}
	}
	public void select() {
		int number = BitGlobal.inputNumber("Enter id");
		int index = numToIndex(number);
		if(index==-1) System.out.println("Not found");
		else {
			Member m = (Member) arr.getData(index);
			m.printLn();
		}
	}
	public void selectAll() {
		System.out.println("size: " + arr.getSize());
		for (int i = 0 ; i < arr.getSize(); i ++) {
			Member m = (Member) arr.getData(i);
			m.print();
		}
	}
	public void update() {
		try {
			String name = BitGlobal.inputString("Enter name");
			String phone = BitGlobal.inputString("Enter new contact info");
			Member m = nameToMember(name);
			if(m==null) throw new Exception("Not found");
			m.setPhone(phone);
			System.out.println("Successfully updated");
			m.printLn();
		}
		catch(Exception e) {
			System.out.println("Update error: "+e.getMessage());
		}
	}
	public void delete() {
		try {
			int number = BitGlobal.inputNumber("Enter id");
			int index = numToIndex(number);
			if(index == -1) throw new Exception("Not found");
			arr.delete(index);
			System.out.println("Successfully deleted");
		}
		catch(Exception e) {
			System.out.println("Delete error: " + e.getMessage());
		}
	}
	//helper
	private Member nameToMember(String name) throws Exception {
		for (int i = 0 ; i < arr.getSize(); i ++) {
			Member m = (Member)arr.getData(i);
			if(m.getName().equals(name)) return m;
		}
		throw new Exception("Member does not exist");
	}
	private int numToIndex(int number) {
		for(int i = 0 ; i < arr.getSize(); i ++) {
			Member m = (Member) arr.getData(i);
			if(m.getNumber() == number) return i;
		}
		return -1;
	}
}
class Member{
	private int number;
	private String name;
	private String phone;
	private char sex;
	/*CONSTRUCTORS*/
	public Member(int number, String name, String phone, char sex) {
		this.setNumber(number);
		this.setName(name);
		this.setPhone(phone);
		this.setSex(sex);
	}
	public Member(int number, String name) {
		this(number, name, "", ' ');
	}
	/*METHODS*/
	public void printLn() {
		System.out.println("[ID]: " + this.number);
		System.out.println("[Name]: " + this.name);
		System.out.println("[Contact info]: " + this.phone);
		System.out.println("[Sex]: " + this.sex);
	}
	public void print() {
		System.out.printf("[%d] %s %s %c\n", number, name, phone, sex);
	}
	/*GETTER SETTER*/
	public int getNumber() {
		return number;
	}
	private void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
}
class BitArray{
	private Object[] base;
	private int max;
	private int size;
	//constructor
	public BitArray() { this(10); }
	public BitArray(int max) {
		this.setBase(new Object[max]);
		this.setMax(max);
		this.setSize(0);
	}
	//helper
	private boolean isOverflow() { return size>=max; }
	private boolean isValidIndex(int ind) { return ind >= 0 && ind <= size-1; }
	//methods
	public void insert(Object o) throws Exception {
		if(!this.isOverflow()) {
			base[size] = o;
			size++;
		}
		else throw new Exception("Overflow!");
	}
	public void delete(int ind) throws Exception {
		if(!isValidIndex(ind)) throw new Exception("Invalid index");
		for (int i = ind ; i < size-1; i++) {
			base[i] = base[i+1];
		}
		setSize(size-1);
	}
	
	//getter setter
	public Object getData(int ind) {
		if(!this.isValidIndex(ind)) return null;
		return base[ind];
	}
	public Object[] getBase() {
		return base;
	}
	private void setBase(Object[] base) {
		this.base = base;
	}
	public int getMax() {
		return max;
	}
	private void setMax(int max) {
		this.max = max;
	}
	public int getSize() {
		return size;
	}
	private void setSize(int size) {
		this.size = size;
	}
}
class BitGlobal{
	static Scanner scn = new Scanner(System.in);
	public static void pause() {
		System.out.print("press enter >> ");
		scn.nextLine();
	}
	public static int menu() {
		System.out.println("1) insert");
		System.out.println("2) select");
		System.out.println("3) update");
		System.out.println("4) delete");
		System.out.println("5) exit");
		System.out.print(">> ");
		return Integer.parseInt(scn.nextLine());
	}
	public static void logo() {
		System.out.println("program starting ************");
		pause();
	}
	public static void ending() {
		System.out.println("*************program exiting");
	}
	public static int inputNumber(String msg) {
		System.out.print(msg+" : ");
		return Integer.parseInt(scn.nextLine());
	}
	public static String inputString(String msg) {
		System.out.print(msg+" : ");
		return scn.nextLine();
	}
}