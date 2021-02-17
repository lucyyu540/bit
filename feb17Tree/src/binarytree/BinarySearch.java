package binarytree;

public class BinarySearch {
	public static int search(char[] str, char key) {
		int s = 0, e = str.length-1;
		while(s<e) {
			int mid = (s+e)/2;
			if(str[mid] == key) return mid;
			if(str[mid] < key) s = mid+1;
			else e = mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {1,3,5,10,15,21,22};
		System.out.println(search(str, (char)21));
		System.out.println(search(str, (char)20));
	}

}
