package doublyLinkedList;
public class Room {
	private DList list;
	private String name;
	public Room(String name) {
		setList(new DList());
		setName(name);
	}
	public boolean insert(Object o) {
		return list.backInsert(o);
	}
	public boolean delete(Object o) {
		return list.delete(o);
	}
	public DList getList() {
		return list;
	}
	public void setList(DList list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void print() {
		System.out.printf("%s : [%d명] ",
				this.getName(),
				this.getList().getSize());
		this.list.selectNextAll();
		
	}
}
