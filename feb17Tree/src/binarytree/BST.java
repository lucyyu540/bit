package binarytree;
import common.Node;

public class BST {
	Node root;
	int count;
	public BST() {
		root = null;
		count = 0;
	}
	public void insert(int key) {
		count++;
		if(root == null) {
			root = new Node(key);
			return;
		}
		Node curr = root;
		while(true) {
			if(curr.getKey() < key) {
				if(curr.getRight() == null) {
					curr.setRight(new Node(key));
					break;
				}
				else curr = curr.getRight();
			}
			else {
				if(curr.getLeft() == null) {
					curr.setLeft(new Node(key));
					break;
				}
				else curr = curr.getLeft();
			}
		}
	}
	
	public Node search (int key) { return searchR(this.root, key); }
	private Node searchR (Node root, int key) {
		if(root == null || root.getKey()==key) return root;
		else if(root.getKey() < key) return searchR(root.getRight(), key);
		else return searchR(root.getLeft(), key);
	}

	public boolean delete(int key) {
		Node parent= null, node = this.root;
		//search
		while(node!= null&& node.getKey()!= key) {
			parent = node;
			if(node.getKey()<key) node = node.right;
			else node = node.left;
		}
		if(node == null) return false;
		//childless
		if(node.right == null && node.left == null) {
			if(parent!=null) {
				if(parent.right.equals(node)) parent.right = null;
				else parent.left = null;
			}
			this.root = null;
		}
		//one child
		else if(node.right == null || node.left == null) {
			Node child;
			if(node.left != null) child = node.left;
			else child = node.right;
			if(parent!= null)  {
				if(parent.right.equals(node)) parent.right = child;
				else parent.left = child;
			}
			else this.root = child;
		}
		//two children 
		else {
			Node childp = node, child = node.right;
			while(child.left != null) {//min value on right tree
				childp = child;
				child = child.left;
			}
			int temp = child.getKey();
			if(childp.right.equals(child)) childp.right = child.right;
			else childp.left = child.right;
			node.setKey(temp);			
		}
		
		return true;
	}

	private void innerinorder(Node root) {
		if(root!= null) {
			innerinorder(root.left);
			System.out.print(root.getKey()+ " ");
			innerinorder(root.right);
		}
	}
	public void inorder() { innerinorder(this.root);}

}
