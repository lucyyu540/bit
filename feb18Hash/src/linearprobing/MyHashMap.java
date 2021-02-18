package linearprobing;

public class MyHashMap {
	private Object[] array;
	private int max;//max num of objects stored
	private int bucketMax;//actual size of the array
	private int size;
	/*CONSTRUCTOR*/
	public MyHashMap(int m) {
		this.max = m;
		this.bucketMax = (int) (this.max*1.2);
		setArray(new Object[bucketMax]);
		clear();
	}
	/*METHODS*******************************/
	/*INSERT*/
	public boolean insert(Object data) {
		System.out.println("in insert");
		if(isOverflow() || !isUnique(data)) return false;
		int i = hashFunction(data.hashCode());
		while ((int) array[i] != -1 && (int) array[i] != -2 ) {
			i = (i+1)%bucketMax;//원형 증가
		}
		array[i] = data;
		size++;
		return true;
	}
	private boolean isUnique(Object data) {
		for (int i = 0 ; i < array.length; i ++) {
			if((int) array[i] == -1 || (int) array[i] == -2) continue;
			Member mem = (Member) array[i];
			if(mem.equals(data)) return false;
		}
		return true;
	}
	/*SELECT*/
	public int select(Object key) {//id --> Member
		int i = hashFunction(key);
		int count = 0;
		while (true) {
			if(count > size) break;
			try {
				if( (int) array[i] == -1) break;
			}
			catch(Exception e) {
				//array[i] is int
				if(array[i].hashCode() == (int) key) return i;
			}
			count ++;
			i = (i+1)%bucketMax;
		}
		return -1;
	}
	public Object keyToValue(Object key) {
		int i = select(key);
		return i == -1 ? null : array[i];
	}
	/*DELETE*/
	public boolean delete( Object key) {
		int res = select(key);
		if(res == -1) return false;
		array[res] = -2;
		size --;
		return true;
	}
	public void printAll() {
		System.out.println("----------------------------------");
		for (int i = 0 ; i < array.length; i ++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0 ; i < array.length; i ++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println("\n----------------------------------");
		
	}
	public void clear() {
		for (int i = 0 ; i < array.length; i ++)array[i] = -1;
		size = 0;
	}
	/**HELPER*********************************************/
	private boolean isOverflow() {return size >= max;}
	private int hashFunction(Object key) {
		return (int) key%bucketMax;
	}
	/** GETTER SETTER*************************************/
	public Object[] getArray() {
		return array;
	}
	public void setArray(Object[] array) {
		this.array = array;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
class PairData {
	int key;
	Member value; 
	public PairData(Member mem) {
		this.key = mem.getNumber();
		value = mem;
	}
}
