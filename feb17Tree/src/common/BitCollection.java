package common;

public interface BitCollection {
	int getSize();    		//[public abstract] int getSize(); //추상 메서드
	Object getData(int idx);
	void insert(Object obj) throws Exception;
	void delete(int idx) throws Exception;
}
