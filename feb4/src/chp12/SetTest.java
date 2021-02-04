package chp12;
import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("park"); ts.add("kim"); ts.add("lee");
		System.out.println("treeset:" + ts);
		
		
		Set<String> hs = new HashSet<String>();
		hs.add("milk"); hs.add("bread"); hs.add("butter"); hs.add("cheese"); hs.add("ham"); hs.add("ham");
		System.out.println("hashset:" + hs);

		//sorting set into list
		List<String> l = new ArrayList<String>(hs);
		Collections.sort(l);
		System.out.println("ordered list: " + l);
		Collections.sort(l, Collections.reverseOrder());
		System.out.println("reverse-ordered list: " + l);
		
		//set methods
		HashSet<String> A =new HashSet<String>();
		String[] fruits = {"apple", "banana", "tomato", "apple"};
		for (String fruit : fruits) {
			if(A.add(fruit)) System.out.println(fruit);
			else System.out.println("skip");
		}
		System.out.println(A.size());
		//set union/intersection
		HashSet<String> B =new HashSet<String>();
		B.add("apple"); B.add("banana"); B.add("grape");
		HashSet temp = (HashSet) B.clone();
		B.retainAll(A);
		System.out.println("in both: " + B);
		A.removeAll(B);
		System.out.println("only in A: " + A);
		temp.removeAll(B);
		System.out.println("only in B: " + temp);
	}

}
