package sample;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankAccountManagement {
	public static void main(String[] args) {
		App app = App.getInstance();
		app.run();
		app.exit();
	}
}
/*******************************************************************************************/
class App {
	/*SINGLETON*/
	private App() { init(); }
	private static App singleton = new App();//only instantiated ONCE
	public static App getInstance() { return singleton; } //public access this instance
	private Bank bank = Bank.getInstance();
	public void init() { BitGlobal.logo(); }
	public void run() {
		while (true) {
			bank.printAll();
			switch(BitGlobal.menu()) {
			case 1: //create new acc
				bank.makeAccount(); break;
			case 2: //select account
				bank.selectAccount(); break;
			case 3: //deposit
				bank.inputMoney(); break;
			case 4: //withdraw
				bank.outputMoney(); break;
			case 5: //delete
				bank.deleteAccount(); break;
			case 6: return;//exit
			}
			BitGlobal.pause();
				
		}
		
	}
	public void exit() { BitGlobal.ending(); }
}
/*******************************************************************************************/

class Bank{
	/*SINGLETON*/
	private Bank() {
		arr = new BitArray(inputMax());
		transaction = new BitArray(1000);
	}
	private static Bank singleton = new Bank();
	public static Bank getInstance() { return singleton;}
	/*FIELD*/
	private BitArray arr;
	private BitArray transaction;
	/*HELPER*/
	public int inputMax() {
		return BitGlobal.inputNumber("Enter number");
	}
	private int idToIndex(int id) {
		for(int i = 0 ; i < arr.getSize(); i ++) {
			Account a = (Account) arr.getData(i);
			if(a.getId() == id) return i;
		}
		return -1;
	}
	private boolean isValidId(int id) {
		for(int i = 0; i < arr.getSize(); i ++) {
			Account a = (Account) arr.getData(i);
			if(a.getId() == id) return false;
		}
		return true;
	}
	private void insertTransaction(int id, int input, int output, int balance) throws Exception {
		transaction.insert(new AccountIO(id, input, output, balance));
	}
	private void printTransaction (int id) {
		System.out.println("[ID]\t [+]\t [-]\t [BALANCE]\t [DATE/TIME]");
		for (int i = 0; i < transaction.getSize(); i ++) {
			AccountIO io = (AccountIO) transaction.getData(i);
			if(io.getId() == id) io.print();
		}
	}
	/*METHODS*/
	public void makeAccount() {
		try {
			int id = BitGlobal.inputNumber("Enter id");
			String name = BitGlobal.inputString("Enter name");
			int balance = BitGlobal.inputNumber("Enter balance");
			if(!isValidId(id)) throw new Exception("This id is unavailable");
			arr.insert(new Account(id, name, balance));
			insertTransaction(id, balance, 0, balance);
			System.out.println("Create account successful");
		}
		catch(Exception e) {
			System.out.println("Create account fail: "+e.getMessage());
		}
	}
	public void selectAccount() {
		int id = BitGlobal.inputNumber("Enter id");
		int index = idToIndex(id);
		if(index==-1) System.out.println("Account not found");
		else {
			Account m = (Account) arr.getData(index);
			m.printLn();
			printTransaction(id);
		}
	}
	public void inputMoney() {
		try {
			int id = BitGlobal.inputNumber("Enter id");
			int amount = BitGlobal.inputNumber("Enter amount");
			int index = idToIndex(id);
			if(index==-1) throw new Exception("Account DNE");
			Account a = (Account) arr.getData(index);
			a.inputMoney(amount);
			insertTransaction(id, amount, 0, a.getBalance());
			System.out.println("Deposit successful");
			a.printLn();
		}
		catch(Exception e) {
			System.out.println("Deposit error: "+e.getMessage());
		}
	}
	public void outputMoney() {
		try {
			int id = BitGlobal.inputNumber("Enter id");
			int amount = BitGlobal.inputNumber("Enter amount");
			int index = idToIndex(id);
			if(index==-1) throw new Exception("Account DNE");
			Account a = (Account) arr.getData(index);
			a.outputMoney(amount);
			insertTransaction(id, 0, amount, a.getBalance());
			System.out.println("Withdrawal successful");
			a.printLn();
		}
		catch(Exception e) {
			System.out.println("Withdrawal error: "+e.getMessage());
		}
	}
	public void deleteAccount() {
		try {
			int number = BitGlobal.inputNumber("Enter id");
			int index = idToIndex(number);
			if(index == -1) throw new Exception("Account DNE");
			arr.delete(index);
			System.out.println("Successfully deleted");
		}
		catch(Exception e) {
			System.out.println("Delete error: " + e.getMessage());
		}
	}
	public void printAll() {
		System.out.println("size: " + arr.getSize());
		for (int i = 0 ; i < arr.getSize(); i ++) {
			Account m = (Account) arr.getData(i);
			m.print();
		}
	}
}
/*******************************************************************************************/
class AccountIO {
	private int id;
	private int input;
	private int output;
	private int balance;
	private Calendar time;
	public AccountIO(int id, int input, int output, int balance) {
		this.setId(id);
		this.setInput(input);
		this.setOutput(output);
		this.setBalance(balance);
		this.setTime(Calendar.getInstance());
	}
	public void print() {
		System.out.printf("[%d]\t %d\t %d\t %d\t %s %s\n", id,input, output, balance, getDate(), getTime());
	}
	/*HELPER*/
	private String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(this.time.getTime());
	}
	private String getTime() {
		return new SimpleDateFormat("HH:mm:ss").format(this.time.getTime());
	}
	/*GETTER SETTER*/
	public int getId() {return id;}
	private void setId(int id) { this.id = id; }
	private void setInput(int input) { this.input = input; }
	private void setOutput(int output) {this.output = output;}
	private void setBalance(int balance) {this.balance = balance;}
	private void setTime(Calendar time) {this.time = time;}
}
class Account{
	private int id;
	private int balance;
	private Calendar newTime;
	private String name;
	/*CONSTRUCTORS*/
	public Account(int id, String name, int balance) throws Exception {
		if (balance < 0) throw new Exception("invalid amount");
		this.setId(id);
		this.setName(name);
		this.setBalance(balance);
		this.setNewTime(Calendar.getInstance());
	}
	public Account(int id, String name) throws Exception {
		this(id, name,0);
	}
	/*METHODS*/
	public void inputMoney(int m) throws Exception {
		if(m<=0) throw new Exception("Invalid input!");
		this.setBalance(this.balance+m);
	}
	public void outputMoney(int m) throws Exception {
		if(m<=0) throw new Exception("Invalid input!");
		if(this.balance<m) throw new Exception("Insufficient balance!");
		this.setBalance(this.balance-m);
	}
	public void printLn() {
		System.out.println("[ID]: " + this.id);
		System.out.println("[Name]: " + this.name);
		System.out.println("[balance]: ₩" + this.balance);
		System.out.println("[Date opened]: " + getDate());
		System.out.println("[Time opened]: " + getTime());
	}
	public void print() {
		System.out.printf("[%d] %s %d %s %s\n", id, name, balance, getDate(), getTime());
	}
	/*HELPER*/
	private String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(this.newTime.getTime());
	}
	private String getTime() {
		return new SimpleDateFormat("HH:mm:ss").format(this.newTime.getTime());
	}
	/*GETTER SETTER*/
	public int getId() { return id; }
	private void setId(int id) { this.id = id; }
	public int getBalance() { return balance; }
	private void setBalance(int balance) { this.balance = balance; }
	public Calendar getNewTime() { return newTime; }
	private void setNewTime(Calendar newTime) { this.newTime = newTime; }
	public String getName() { return this.name; }
	private void setName(String name) { this.name = name; }
	
}
/*******************************************************************************************/

class BitArray{
	private Object[] base;
	private int max;
	private int size;
	/*CONSTRUCTORS*/
	public BitArray() { this(10); }
	public BitArray(int max) {
		this.setBase(new Object[max]);
		this.setMax(max);
		this.setSize(0);
	}
	/*HELPER*/
	private boolean isOverflow() { return size>=max; }
	private boolean isValidIndex(int ind) { return ind >= 0 && ind <= size-1; }
	/*METHODS*/
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
	
	/*GETTER SETTER*/
	public Object getData(int ind) {
		if(!this.isValidIndex(ind)) return null;
		return base[ind];
	}
	public Object[] getBase() {return base;}
	private void setBase(Object[] base) {this.base = base;}
	public int getMax() {return max;}
	private void setMax(int max) {this.max = max;}
	public int getSize() {return size;}
	private void setSize(int size) {this.size = size;}
}
/*******************************************************************************************/

class BitGlobal{
	static Scanner scn = new Scanner(System.in);
	public static void pause() {
		System.out.print("press enter >> ");
		scn.nextLine();
	}
	public static int menu() {
		System.out.println("1) create new account");
		System.out.println("2) select account");
		System.out.println("3) deposit");
		System.out.println("4) withdraw");
		System.out.println("5) delete account");
		System.out.println("6) exit");
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
	/*SCANNER*/
	public static int inputNumber(String msg) {
		System.out.print(msg+" : ");
		return Integer.parseInt(scn.nextLine());
	}
	public static String inputString(String msg) {
		System.out.print(msg+" : ");
		return scn.nextLine();
	}
}
