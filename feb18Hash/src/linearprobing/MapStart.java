package linearprobing;

import java.util.Scanner;

public class MapStart {
	MyHashMap map = new MyHashMap(10);
	Scanner scan = new Scanner(System.in);
	public void insert(int number, String name, String phone, char sex) {
		if(map.insert(new Member(number, name, phone, sex))) {
			System.out.println("성공");
		}
		else System.out.println("실패");
	}
	private void select (int id) {
		Member mem = (Member) map.keyToValue(id);
		if(mem == null) System.out.println("없음");
		else mem.print();
	}
	public void delete(int id) {
		map.delete(id);
	}
	public void run() {
		while(true) {			
			map.printAll();
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			if( sp[0].equals("insert")){   //id name phone sex
				insert(Integer.parseInt(sp[1]),
						sp[2], sp[3], sp[4].charAt(0));
			}
			else if(sp[0].equals("select")) { //delete 10
				select(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("delete")) { //delete 10
				delete(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("exit")) {
					break;
			}
		}
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MapStart().run();
	}

}
