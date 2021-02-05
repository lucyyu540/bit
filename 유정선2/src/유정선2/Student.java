package 유정선2;

public class Student {
	String name;
	int grade;
	int money;
	int transfer = 0;
	public Student (String name, int grade, int money) {
		this.name = name;
		this.grade = grade;
		this.money = money;
	}
	public void setTransfer(int i) {
		this.transfer = 0;
	}
	public void transferRide() {
		this.transfer ++;
	}
	public int getTransfer() {return this.transfer;}
	public boolean pay(int x) {
		if(this.money>= x) {
			this.money -= x;
			print();
			return true;
		}
		return false;
	}
	public void print() {
		System.out.println(this.name);
		System.out.println("grade: " + this.grade);
		System.out.println("balance: " + this.money);
	}

}
