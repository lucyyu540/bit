package queue;

public class MyQueue implements ListMethods{
	private int max;
	private Object[] arr;
	private int rear;//index of this input
	private int front;
	public MyQueue(int m) {
		max = m+1;
		/**
		 * f,r	0	0	0	0	0 <- empty
		 * f 	0	0	0	0	r <- full
		 * f,r	0	0	0	0	0 <- overflow and also empty
		 * differentiate isempty(rear=front) and isoverflow (rear = front) by
		 * 
		 * f,r	0	0	0	0	0	x <- empty
		 * f		0	0	0	0	r	X <- full
		 * f		0	0	0	0	0	r <- overflow
		 * conditioning overflow so that is overflower is ( rear+1 = front ) - 
		 * create "padding" by incrementing max size 
		 * so theoretically queue is size m, but for technical reasons array is calculated by size m+1
		 */
		arr = new Object[max];
		rear = front = 0;
		/*
		 * stack is LINEAR 
		 * s,e	0	0	0	<- empty ==> 
		 * s		1	2	e	<- full	 ==>	 
		 	* s = 0 (not even necessary) 
		 	* s is always <= e
		 	*OPT1: stack is empty if e = -1
		 	* 0	0	0	0 (arr[++e] = stack.push(d))
		 	* 0	0	0	e (arr[e--] = stack.pop())
		 	*OPT2: stack is empty if e = 0
		 	* e	0	0	0 (arr[e++] = stack.push(d))
		 	* 0	0	0	0 (arr[--e] = stack.pop())
		 * queue is CYCLIC
		 * 0		0	0	s,e	<- empty
		 * 2		e	s	1 	<- full
		 * only f=r can indicate a full cycle
		 */
	}
	/*METHODS*/
	@Override
	public boolean push(Object o) {
		if(isOverflow()) return false;
		arr[rear] = o;
		rear = incr(rear);
		return true;
	}
	@Override
	public Object pop() {
		if(isEmpty()) return false;
		Object head = arr[front];
		front = incr(front);
		return head;
	}

	@Override
	public Object peek() {
		if(isEmpty()) {
			System.out.println("empty queue!");
			return null;
		}
		return arr[front];
	}

	@Override
	public void printAll() {
		int i = front;
		while (i != rear) {
			System.out.print(arr[i]+" -> ");
			i = incr(i);
		}
		System.out.println();
	}
	@Override
	public void clear() {
		rear = front = 0;		
	}
	/*HELPER*/
	public boolean isEmpty() {
		return rear==front;
	}
	public boolean isOverflow() {
		return incr(rear)==front;//full
	}
	public int incr(int i ) {
		return (i+1)%max;
	}
	


}