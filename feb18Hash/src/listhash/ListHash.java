package listhash;

public class ListHash {
	DList[] arr;
	int max;
	int size;
	public ListHash(int m ) {
		max = m;
		size = 0;
		arr = new DList[max];
		for(int i = 0 ; i < arr.length; i ++) {
			arr[i] = new DList();
		}
	}
	/*METHODS*******************************/
	/*INSERT*/
	public boolean insert(Object data) {
		int i = hashFunction(data);
		arr[i].backInsert(data);
		size++;
		return true;
	}
	private boolean isUnique(Object key) {
		for (int i = 0 ; i < arr.length; i ++) {
			DList list = arr[i];
			DList.DNode node = list.select(key);
			if(node != null) return false;
		}
		return true;
	}
	/*SELECT*/
	public Object select(Object key) {
		DList list = arr[hashFunction(key)];
		DList.DNode node = list.select(key);
		if(node != null) return null;
		return node.getData();
	}
	/*DELETE*/
	public boolean delete(Object key) {
		DList list = arr[hashFunction(key)];
		return list.delete(key);
	}
	public void printAll() {
		System.out.println("----------------------------------");
		for (int i = 0 ; i < arr.length; i ++) {
			arr[i].selectNextAll();
		}
		System.out.println("\n----------------------------------");
		
	}
	public void clear() {
		for (int i = 0 ; i < arr.length; i ++) arr[i].clear();
	}
	private int hashFunction(Object key) {
		return (int) key;
	}
	/** GETTER SETTER*************************************/
	public Object[] getArray() {
		return arr;
	}
	public void setArray(DList[] arr) {
		this.arr = arr;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
