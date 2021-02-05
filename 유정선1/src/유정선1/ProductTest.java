package 유정선1;
import java.util.*;
public class ProductTest {
	static int m;
	static List<Product> myProducts = new ArrayList<Product>();
	public static void menu() {
		System.out.println("잔액: " + m); 
		System.out.println("1) TV");
		System.out.println("2) Computer");
		System.out.println("3) Exit");
		System.out.print("> Select product: ");
	}
	public static void buy(Product p) {
		if(p.getPrice()<= m) {
			m-= p.getPrice();
			myProducts.add(p);
			System.out.println("구입 성공");
		}
		else System.out.println("잔액 부족");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("잔액: ");
		m = in.nextInt();
		while(true) {
			menu();
			int select = in.nextInt();
			if(select == 1) buy(new TV());
			else if(select == 2) buy(new Computer());
			else if(select == 3) break;
		}
		System.out.println("총 구매한 재품들:");
		for (Product p : myProducts) {
			System.out.println(p.getName());
		}
		

	}

}
