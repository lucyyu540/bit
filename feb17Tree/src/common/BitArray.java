package common;
/*
 * Java : extends[확장] / implements[생성,구현상속]
 * 
 * [부모]   class A              interface IA                 interface IA
 * [자식]   class B extends A    interface IB extends IA      class C implements IA
 */
public class BitArray implements BitCollection{
	private Object[] base;
	private int max;
	private int size;
	/*CONSTRUCTORS*/
	public BitArray() { this(10); }
	public BitArray(int max) {
		this.setBase(new Object[max]);
		this.setMax(max);
		this.setSize(0);
	}
	/*HELPER*/
	private boolean isOverflow() { return size>=max; }
	private boolean isValidIndex(int ind) { return ind >= 0 && ind <= size-1; }
	/*METHODS*/
	@Override
	public void insert(Object o) throws Exception {
		if(!this.isOverflow()) {
			base[size] = o;
			size++;
		}
		else throw new Exception("Overflow!");
	}
	@Override
	public void delete(int ind) throws Exception {
		if(!isValidIndex(ind)) throw new Exception("Invalid index");
		for (int i = ind ; i < size-1; i++) {
			base[i] = base[i+1];
		}
		setSize(size-1);
	}
	
	/*GETTER SETTER*/
	@Override
	public Object getData(int ind) {
		if(!this.isValidIndex(ind)) return null;
		return base[ind];
	}
	public Object[] getBase() {return base;}
	private void setBase(Object[] base) {this.base = base;}
	public int getMax() {return max;}
	private void setMax(int max) {this.max = max;}
	@Override
	public int getSize() {return size;}
	private void setSize(int size) {this.size = size;}
}
