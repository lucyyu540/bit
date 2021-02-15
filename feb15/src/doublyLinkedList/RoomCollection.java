package doublyLinkedList;

import java.util.Scanner;

public class RoomCollection {
	static Room[] rooms;
	static void setRooms(int n) {
		rooms = new Room[n+1];
		rooms[0] = new Room("대기방");
		for (int i = 1 ; i <= n; i++) {
			rooms[i] = new Room("게임방"+i);
		}
	}
	/*HELPER*/
	static void print() {
		for (int i = 0 ; i < rooms.length; i ++) {
			rooms[i].print();
		}
	}
	static boolean validRoomNumber(String i) {
		if(Integer.parseInt(i) >= 1 && Integer.parseInt(i) <= rooms.length-1) return true;
		System.out.println("Invalid room number!");
		return false;
	}
	/*METHODS*/
	static boolean gamein(String i, Object o) {
		if(!validRoomNumber(i)) return false;
		if(rooms[0].delete(o)) return rooms[Integer.parseInt(i)].insert(o);
		System.out.println("user " + o + " not in waiting room");
		return false;
	}
	static boolean gameout(String i, Object o) {
		if(!validRoomNumber(i)) return false;
		if(rooms[Integer.parseInt(i)].delete(o)) return rooms[0].insert(o);
		System.out.println("user " + o + " not room " + i);
		return false;
	}
	
	static void run() {
		Scanner in = new Scanner(System.in);
		System.out.println("PROGRAM STARTING **************");
		System.out.print("no. of rooms: ");
		setRooms(Integer.parseInt(in.nextLine()));
		Loop : while(true) {
			print();
			System.out.print(">>");
			String[] arr = in.nextLine().split(" ");
			switch(arr[0]) {
			case "insert": rooms[0].insert(arr[1]); break;
			case "gamein" : gamein(arr[1], arr[2]); break;
			case "gameout" : gameout(arr[1], arr[2]); break;
			case "exit": break Loop;
			}
		}
		in.close();
		System.out.println("PROGRAM ENDING **************");
	}
	public static void main(String[] args) {
		new RoomCollection().run();
	}

}
