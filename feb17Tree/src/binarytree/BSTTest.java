package binarytree;
import common.Node;
public class BSTTest {
	public static void main(String[] args) {
		BST bst = new BST();
		System.out.print("저장값 : ");
		for(int i=0; i<10; i++) {			
			int value = (int)(Math.random()*100)+1; //1~100
			System.out.print(value + " ");
			bst.insert(value);
		}
		
		System.out.println("\n[순회 결과값]");
		bst.inorder();
		//검색 테스트....
		int value = (int)(Math.random()*100)+1; //1~100
		Node node = bst.search(value);
		if(node == null) System.out.println(" 없다 (" + value+")");
		else System.out.println("찾은값 ; " + node.getKey());
		
	}

}
