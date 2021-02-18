package linearprobing;

public class MyHash {
	private Object[] array;
	private int max;//max num of objects stored
	private int bucketMax;//actual size of the array
	private int size;
	/*CONSTRUCTOR*/
	public MyHash(int m) {
		this.max = m;
		this.bucketMax = (int) (this.max*1.2);
		setArray(new Object[bucketMax]);
		clear();
	}
	/*METHODS*******************************/
	/*INSERT*/
	public boolean insert(Object data) {
		if(isOverflow() || select(data)!= -1) return false;
		int i = hashFunction(data);
		while ((int) array[i] != -1 && (int) array[i] != -2 ) {
			i = (i+1)%bucketMax;//원형 증가
		}
		array[i] = data;
		size++;
		return true;
	}
	/*SELECT*/
	public int select(Object key) {
		for (int i = hashFunction(key); (int) array[i] != -1; i = (i+1)%bucketMax) {
			if(array[i] == key) return i;
		}
		return -1;
	}
	/*DELETE*/
	public boolean delete(Object key) {
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
