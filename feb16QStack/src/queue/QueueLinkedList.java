package queue;
import stack.DList;
public class QueueLinkedList implements ListMethods{
	DList list;
	public QueueLinkedList() {
		list = new DList();
	}
	public boolean push(Object data) {
		return list.backInsert(data);
	}
	public Object pop() {
		if(list.getHead()== null) {
			return null;
		}
		Object head = peek();
		list.frontDelete();
		return head;
		
	}
	public Object peek() {
		if(list.getHead()== null) {
			return null;
		}
		return list.getHead().getData();
	}
	public void printAll() {
		list.selectNextAll();
	}
	public void clear() {list.clear();}
	

}
