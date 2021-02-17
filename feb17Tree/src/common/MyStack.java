package common;

public class MyStack {
	private int max;
	private Object[] arr;
	private int top;//index of last input
	public MyStack(int m) {
		setMax(m);
		setArr(new Object[max]);
		setTop(-1);
	}
	/*METHODS*/
	public Object pop() {
		if(isEmpty()) return null;
		return arr[top--];
	}
	public boolean push(Object data) {
		if(IsOverflow()) return false;
		arr[++top] = data;
		return true;
	}
	public Object peek() {
		try { return arr[top];}
		catch (Exception e) { 
			System.out.print("비어있습니다");
			return null;
		}
	}
	public void clear() {top = -1;}
	/*HELPER*/
	public boolean isEmpty() {return top < 0;}
	private boolean IsOverflow() {return top+1 >= max;}
	public void printAll() {
		for (int i = 0; i<=top ; i ++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
	
	/*gETTER SETTER	 */
	public int getMax() {return max;}
	public void setMax(int max) {this.max = max;}
	public MyStack() {this(10);}
	public Object[] getArr() {return arr;}
	public void setArr(Object[] arr) {this.arr = arr;}
	public int getTop() {return top;}
	public void setTop(int top) {this.top = top;}

}
