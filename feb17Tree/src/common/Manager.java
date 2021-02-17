package common;
/*
 * BitArray
 * 1) getSize() 
 * 2) getData(idx) 
 * 3) Insert(��������)
 * 4) Delete(idx) 
 */
public class Manager {
	private BitArray arr = new BitArray();	

	public void selectAll() {
		System.out.println("[���尳��] " + arr.getSize() + "��");
		for(int i=0; i< arr.getSize(); i++)
		{
			int number = (int)arr.getData(i);  //Down Casting...-> instanceof
			System.out.println(number);
		}
	}
	
	public void insert() {
		try {
			arr.insert(10);		
			//4. ������
			System.out.println("���� ����!");
		}
		catch(Exception ex) {
			System.out.println("[�������] " + ex.getMessage());
		}
	}
	private int NumberToIdx(int number) {
		for(int i=0; i< arr.getSize(); i++) {
			int num = (int)arr.getData(i);
			if( num == number)
				return i;
		}
		return -1;
	}	
	
	public void select() {
		int idx = NumberToIdx(10);
		if(idx != -1) {
			int number = (int)arr.getData(idx);
			System.out.println(number);
		}
		else
			System.out.println("����\n");
	}
	
	public void update() {
		try {
			//int idx = NameToMember(10);
			//arr.getData(idx)= 20;
			System.out.println("���� ����\n");
		}
		catch(Exception ex) {
			System.out.println("[��������]" + ex.getMessage());
		}
	}
	
	public void delete() {
		try {			
			int idx = NumberToIdx(10);
			if(idx == -1) 
				throw new Exception("���� ȸ����ȣ �Դϴ�.");	//<=======			
			arr.delete(idx);
			System.out.println("�����Ǿ����ϴ�.");
		}
		catch(Exception ex) {
			System.out.println("[���� ����] " + ex.getMessage());
		}
	}
}


