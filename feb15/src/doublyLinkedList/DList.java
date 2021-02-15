package doublyLinkedList;


public class DList {
	public class DNode {
		private Object data;
		private DNode next;
		private DNode prev; 
		/*CONSTRUCTORS*/
		public DNode(Object data) {
			this(data,null, null);
		}
		public DNode(Object data, DNode prev, DNode next) {
			this.setData(data);
			this.setPrev(prev);
			this.setNext(next);
		}
		public Object getData() {return data;}
		public void setData(Object data) {this.data = data;}
		public DNode getNext() {return next;}
		public void setNext(DNode next) {this.next = next;}
		public DNode getPrev() {return prev;}
		public void setPrev(DNode prev) {this.prev = prev;}

	}
	private DNode head;
	private DNode tail;
	private int size;
	public DList () {
		setTail(null);
		setHead(null);
		setSize(0);
	}

	/*INSERT*/
	public boolean frontInsert(Object data) {
		DNode n = new DNode(data, null, head);//DNode(data, prev, next)
		if(head == null) tail = n;
		else head.setPrev(n);
		head = n;
		size++;
		return true;
	}
	public boolean backInsert(Object data) {
		DNode n = new DNode(data, tail, null);//DNode(data, prev, next)
		if(tail == null) head = n;
		else tail.setNext(n);
		tail = n;
		size++;
		return true;
	}
	public boolean insert(Object a, Object b) {
		DNode n = select(a);
		return insert(n, b);
	}
	public boolean insert(DNode n, Object data) {
		if(n==null) return false;
		if(n.getNext()==null) return backInsert(data);
		DNode newNode = new DNode(data, n, n.getNext());//DNode(data, prev, next)
		n.setNext(newNode);
		newNode.getNext().setPrev(newNode);
		size++;
		return true;
	}
	/*SELECT*/
	public void selectNextAll() {
		DNode curr = head;
		while(curr != null) {
			System.out.print(curr.getData()+ " -> ");
			curr = curr.getNext();
		}
		System.out.println();
	}
	public void selectPrevAll() {
		DNode curr = tail;
		while(curr != null) {
			System.out.print(curr.getData()+ " <- ");
			curr = curr.getPrev();
		}
		System.out.println();
	}
	public DNode select(Object o ) {
		DNode curr = head;
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
		DNode curr = select(o);
		return delete(curr);
	}
	public boolean delete(DNode n) {
		if(n == null) return false;
		if(n.getPrev()==null) return frontDelete();//head
		if(n.getNext() == null) return backDelete();//tail
		n.getPrev().setNext(n.getNext());//prev -> next
		n.getNext().setPrev(n.getPrev());//prev <- next
		size--;
		return true;
	}
	/*-------------------------GETTER SETTER-------------------------------*/
	public DNode getHead() {return head;}
	public void setHead(DNode head) {this.head = head;}
	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}
	public DNode getTail() {return tail;}
	public void setTail(DNode tail) {this.tail = tail;}
}
