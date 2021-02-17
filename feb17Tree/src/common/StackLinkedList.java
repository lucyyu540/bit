package common;

public class StackLinkedList {
	private BitLinkedList list;
	public StackLinkedList() {
		list = new BitLinkedList();
	}
	public boolean push(Object data) {
		return list.frontInsert(data);
	}
	public Object pop() {
		if(list.getHead()==null) {
			return null;
		}
		Object head = list.getHead().getData();
		list.frontDelete();
		return head;
	}
	public Object peek() {
		if(list.getHead()== null) {
			return null;
		}
		return list.getHead().getData();
	}
	public void printAll() {list.selectPrevAll();}
	public void clear() {list.clear();}

}
