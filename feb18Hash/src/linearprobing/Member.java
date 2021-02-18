package linearprobing;

public class Member {
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
	@Override
	public boolean equals(Object o) {
		return this.getNumber() == ((Member) o).getNumber();
		
	}
	@Override
	public int hashCode() {
		return this.getNumber();
	}
	/*GETTER SETTER*/
	public int getNumber() {return number;}
	private void setNumber(int number) {this.number = number;}
	public String getName() {return name;}
	private void setName(String name) {this.name = name;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public char getSex() {return sex;}
	public void setSex(char sex) {this.sex = sex;}
}
