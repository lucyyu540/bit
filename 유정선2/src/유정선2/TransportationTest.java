package 유정선2;
import java.util.*;
public class TransportationTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("enter name: ");
		String name = in.next();
		System.out.print("enter grade: ");
		int grade = in.nextInt();
		System.out.print("enter amount: ");
		int amount = in.nextInt();
		Student student = new Student(name, grade, amount);
		Bus bus = new Bus(123);
		Subway subway = new Subway(2);
		while(true) {
			System.out.println("1) get on a bus");
			System.out.println("2) get on a subway");
			System.out.println("3) get off(exit)");
			int select = in.nextInt();
			if( select == 1) {
				bus.giveRide(student);
			}
			else if(select == 2) {
				subway.giveRide(student);
			}
			else if(select == 3) break;
		}
		System.out.print("student's balance: ");
		student.print();
		System.out.print("bus revenue: ");
		bus.print();
		System.out.print("subway revenue: ");
		subway.print();

	}

}
