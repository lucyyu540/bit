package linearprobing;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap hs = new MyHashMap(10);
		for (int i = 0 ; i < 20; i ++) {
			int value = (int)(Math.random()*10)+1;
			System.out.print(value + "\t");
			hs.insert(value);
		}
		System.out.println();
		hs.printAll();
		
		hs.delete(3);
		hs.printAll();
	}

}
