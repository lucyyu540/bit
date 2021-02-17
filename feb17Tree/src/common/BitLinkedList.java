package common;

public class BitLinkedList implements BitCollection{
	public class Node {
		private Object data;
		private Node next;
		private Node prev; 
		/*CONSTRUCTORS*/
		public Node(Object data) {
			this(data,null, null);
		}
		public Node(Object data, Node prev, Node next) {
			this.setData(data);
			this.setPrev(prev);
			this.setNext(next);
		}
		public Object getData() {return data;}
		public void setData(Object data) {this.data = data;}
		public Node getNext() {return next;}
		public void setNext(Node next) {this.next = next;}
		public Node getPrev() {return prev;}
		public void setPrev(Node prev) {this.prev = prev;}

	}
	private Node head;
	private Node tail;
	private int size;
	public BitLinkedList () {
		setTail(null);
		setHead(null);
		setSize(0);
	}
	public void clear() {
		head = tail = null;
		size = 0;
	}
	/*INSERT*/
	public boolean frontInsert(Object data) {
		Node n = new Node(data, null, head);//DNode(data, prev, next)
		if(head == null) tail = n;
		else head.setPrev(n);
		head = n;
		size++;
		return true;
	}
	public boolean backInsert(Object data) {
		Node n = new Node(data, tail, null);//DNode(data, prev, next)
		if(tail == null) head = n;
		else tail.setNext(n);
		tail = n;
		size++;
		return true;
	}
	public boolean insert(Object a, Object b) {
		Node n = select(a);
		return insert(n, b);
	}
	private boolean insert(Node n, Object data) {
		if(n==null) return false;
		if(n.getNext()==null) return backInsert(data);
		Node newNode = new Node(data, n, n.getNext());//DNode(data, prev, next)
		n.setNext(newNode);
		newNode.getNext().setPrev(newNode);
		size++;
		return true;
	}
	/*SELECT*/
	public void selectNextAll() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.getData()+ " -> ");
			curr = curr.getNext();
		}
		System.out.println();
	}
	public void selectPrevAll() {
		Node curr = tail;
		while(curr != null) {
			System.out.print(curr.getData()+ " <- ");
			curr = curr.getPrev();
		}
		System.out.println();
	}
	public Node select(Object o ) {
		Node curr = head;
		while(curr != null) {
			if(curr.getData().equals(o)) return curr;
			curr = curr.getNext();
		}
		return null;
	}
	/*DELETE*/
	public boolean frontDelete() {
		if(head == null) return false;
		head = head.getNext();
		if(head == null) tail = null;
		else head.setPrev(null);
		size--;
		return true;
	}
	public boolean backDelete() {
		if(tail == null) return false;//노드가 없음
		tail = tail.getPrev();
		if(tail == null) head = null;//노드가 하나
		else tail.setNext(null);//노드가 2+
		size --;
		return true;
	}
	public boolean delete(Object o) {
		Node curr = select(o);
		return delete(curr);
	}
	public boolean delete(Node n) {
		if(n == null) return false;
		if(n.getPrev()==null) return frontDelete();//head
		if(n.getNext() == null) return backDelete();//tail
		n.getPrev().setNext(n.getNext());//prev -> next
		n.getNext().setPrev(n.getPrev());//prev <- next
		size--;
		return true;
	}
	/*-------------------------GETTER SETTER-------------------------------*/
	public Node getHead() {return head;}
	public void setHead(Node head) {this.head = head;}
	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}
	public Node getTail() {return tail;}
	public void setTail(Node tail) {this.tail = tail;}
	@Override
	public Object getData(int idx) {
		Node curr = head;
		for(int i = 0 ; i <= idx; i ++) {
			curr = curr.getNext();
			if(curr==null) return null;
		}
		return curr.getData();
	}
	@Override
	public void insert(Object obj) throws Exception {
		if(!backInsert(obj)) throw new Exception("insert fail");
	}
	@Override
	public void delete(int idx) throws Exception {
		Node curr = head;
		for(int i = 0 ; i <= idx; i ++) {
			curr = curr.getNext();
			if(curr==null) throw new Exception("delete(index) index not found");;
		}
		if(!delete(curr)) throw new Exception("delete(index) fail");
	}
}
