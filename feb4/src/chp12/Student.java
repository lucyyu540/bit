package chp12;
public class Student<T> {
	private T name;
	public void setName(T n) {this.name = n;}
	public T getName() {return this.name;}
	
	public static void main(String[] arg) {
		Student<String> s = new Student<String>();
		s.setName("blah");
		System.out.println(s.getName());
	}
}
