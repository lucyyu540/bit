package 유정선3;
import java.util.*;
public class addressBook{
	static Map<String, String> map = new HashMap<String, String>();
	public static void add() {
		Scanner in = new Scanner(System.in);
		System.out.print("name: ");
		String name = in.next();
		System.out.print("num: ");
		String num = in.next();
		map.put(name, num);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			add();
			System.out.println("continue? y/n");
			if(in.next().equals("n")) break;
		}
		while(true) {
			System.out.println("1) add new num");
			System.out.println("2) search num");
			System.out.println("3) delete num");
			System.out.println("4) print num ");
			System.out.println("5) terminate");
			int select = in.nextInt();
			if(select == 5) System.exit(0);
			else if(select == 1) add();
			else if( select == 2) {
				System.out.print("name: ");
				String name = in.next();
				System.out.println(map.get(name));
			}
			else if(select == 3) {
				System.out.print("name: ");
				String name = in.next();
				map.remove(name);
			}
			else if(select == 4) {
				Set<String> keys = new TreeSet<String>(map.keySet());
				for (String k : keys) {
					System.out.println(k+ " " + map.get(k));
				}                                        
			}
			else if(select == 5) System.exit(0);
		}
		
		

	}
}
