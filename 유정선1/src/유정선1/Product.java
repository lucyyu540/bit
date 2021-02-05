package 유정선1;

public class Product {
	private int price;
	private String name;
	public Product(int p, String n) {
		this.price = p;
		this.name = n;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}

}
