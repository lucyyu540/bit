package theatre;
import java.util.*;
public class ReserveTickets {
	public static void main(String[] args) {
		int[] seats= new int[10];
		Scanner in = new Scanner(System.in);
		int count = 0;
		while(count<10) {
			print(seats);
			System.out.print("enter seat 1-10: ");
			int seat = in.nextInt()-1;
			if(seats[seat] == 0) {
				seats[seat] = 1;
				count ++;
				System.out.println("reservation for seat "+ (seat+1) + " successful");
			}
			else System.out.println("this seat is already taken");
		}
		in.close();
	}
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++ ) {
			if(arr[i] == 0) System.out.println((i+1) + " : EMPTY" );
			else System.out.println((i+1) + " : TAKEN" );
		}
	}
}
