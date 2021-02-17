package tree;

public class Start {

	public static void main(String[] args) {
		ParseTree tree = new ParseTree();
		String s = "3 2 + 4 * 2 -"; //count = 7, root = '-'
		tree.makeParseTree(s);
		
		System.out.println("PRE");
		tree.preorder();
		System.out.println();
		tree.stackpreorder();
		
		System.out.println("\n\nIN");
		tree.inorder();
		System.out.println();
		tree.stackinorder();
		
		System.out.println("\n\nPOST");
		tree.postorder();
		System.out.println();
		tree.stackpostorder();
		
	}

}
