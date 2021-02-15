package singlyLinkedList;

import java.util.Scanner;

class Node {
	private Object data;
	private Node next;
	/*CONSTRUCTORS*/
	public Node(Object data) {
		this(data,null);
	}
	public Node(Object data, Node next) {
		this.setData(data);
		this.setNext(next);
	}
	public Object getData() {return data;}
	public void setData(Object data) {this.data = data;}
	public Node getNext() {return next;}
	public void setNext(Node next) {this.next = next;}

}
class MyList {
	private Node head;//starting node
	private int size;
	public MyList() {
		this.setHead(null);
		this.setSize(0);
	}
	public void frontInsert(Object data) {
		Node newNode = new Node(data);
		if(head == null) head = newNode;
		else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}
	public void backInsert(Object data) {
		Node newNode = new Node(data);
		if(head == null) head = newNode;
		else {
			Node current = head;
			while(current.getNext()!= null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		size++;
	}
	public boolean randomInsert(Node curr, Object data) {
		if(curr==null) return false;
		Node newNode = new Node(data, curr.getNext());
		curr.setNext(newNode);
		size++;
		return true;
	}
	public void selectAll() {
		Node current = head;
		while(current!= null) {
			System.out.print(current.getData()+ " -> ");
			current = current.getNext();
		}
		System.out.println();
	}
	public Node select(Object key) {
		Node current = head;
		while(current!= null) {
			if(current.getData().equals(key)) return current;
			current = current.getNext();
		}
		return null;
	}
	public void deleteNthNode(int d ) {
		if(d>size || d <1) {
			System.out.println("invalide node");
			return;
		}
		if(d == 1) {
			head = head.getNext();
			return;
		}
		int i = 1;
		Node prev = head;
		while (i+1<d) {
			prev = prev.getNext();
			i++;
		}
		//i-1			i			i+1
		prev.setNext(prev.getNext().getNext());
		size --;
		
	}
	public boolean deleteNode(Object o ) {
		Node prev= head, curr = head;
		while (curr!=null) {
			if(curr.getData().equals(o)) {
				if(curr.equals(head)) head = head.getNext();//deleting head
				else prev.setNext(curr.getNext());//deleting curr
				size --;
				return true;
			}
			prev = curr;
			curr = curr.getNext();
		}
		return false;
	}
	public boolean frontDelete() {
		if(head == null) return false;
		head = head.getNext();
		size--;
		return true;
	}
	public boolean backDelete() {
		if(head == null) return false;
		if(head.getNext()==null) head = null;
		else {
			Node prev= head, curr = head;
			while (curr.getNext() != null) {
				prev = curr;
				curr=curr.getNext();
			}
			prev.setNext(null);
		}
		size--;
		return true;
		
	}
	public boolean randomDelete(Node prev) {
		if(prev == null || prev.getNext()== null) return false;
		if(prev.getNext().getNext() == null) prev.setNext(null); //delete last
		else prev.setNext(prev.getNext().getNext());
		size--;
		return true;
	}
	
	public Node getHead() {return head;}
	public void setHead(Node head) {this.head = head;}
	public int getSize() {return size;}
	public void setSize(int count) {this.size = count;}
}
public class Start {
	public static void exam1() {
		MyList list = new MyList();
		list.frontInsert(1);
		list.frontInsert(2);
		list.backInsert(3);
		list.backInsert(4);
		list.backInsert(5);//2,1,3,4,5
		System.out.print("data 3 found: ");
		System.out.println(list.select(3)!=null);
		list.deleteNthNode(2);//2,3,4,5
		list.frontDelete();//3,4,5
		list.deleteNode(4);//3,5
		list.backDelete();//3
		list.selectAll();
	}
	public static void exam2() {
		MyList list = new MyList();
		Scanner in = new Scanner(System.in);
		System.out.println("************exam2************");
		Loop : while(true) {
			System.out.print(">> ");
			String input = in.nextLine();
			String[] arr = input.split(" ");
			switch(arr[0]) {
			case "finsert": list.frontInsert(arr[1]); break;
			case "binsert" : list.backInsert(arr[1]); break;
			case "selectall" : list.selectAll(); break;
			case "select" : System.out.println(list.select(arr[1])!=null? "found" : "not found"); break;
			case "fdelete" : list.frontDelete(); break;
			case "bdelete" : list.backDelete(); break;
			case "randominsert" : 
				list.randomInsert(list.select(arr[1]), arr[2]); 
				break;
			case "randomdelete" : 
				list.randomDelete(list.select(arr[1])); 
				break;
			case "exit" : break Loop;
			}
		}
		in.close();
		System.out.println("************exam2************");
	}
	public static void main(String[] args) {
		exam2();
	}
}
