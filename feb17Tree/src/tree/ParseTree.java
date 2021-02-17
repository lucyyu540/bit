package tree;
import common.Node;
import common.StackLinkedList;
public class ParseTree {
	private Node root;
	private int count;
	public ParseTree() {
		setRoot(null);
		setCount(0);
	}
	public ParseTree(int k) {
		setRoot(new Node(k));
		setCount(1);
	}
	/*METHODS*/
	/**PRE*/
	void innerpreorder(Node root) {
		if(root!= null) {
			System.out.print((char)root.getKey()+ " ");
			innerpreorder(root.left);
			innerpreorder(root.right);
		}
	}
	void preorder() { innerpreorder(this.root);}
	void stackpreorder() {
		StackLinkedList stack = new StackLinkedList();
		Node node = this.root;
		stack.push(node);
		while(stack.peek() != null) {
			node = (Node) stack.pop();
			System.out.print((char) node.getKey() + " ");
			if(node.right!= null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
			
		}
	}
	/**IN*/
	void innerinorder(Node root) {
		if(root!= null) {
			innerinorder(root.left);
			System.out.print((char)root.getKey()+ " ");
			innerinorder(root.right);
		}
	}
	void inorder() { innerinorder(this.root);}
	void stackinorder() {
		StackLinkedList stack = new StackLinkedList();
		Node node = this.root;
		while(true) {
			while(node!= null) {
				stack.push(node);
				node = node.left;
			}
			if(stack.peek()==null) return;
			node = (Node) stack.pop();
			System.out.print((char) node.getKey() + " ");
			node = node.right;
		}
		/*
		StackLinkedList stack = new StackLinkedList();
		Node node = this.root;
		stack.push(node);
		while(stack.peek() != null) {
			while(node.left != null) {
				node = node.left;
				stack.push(node);
			}
			node = (Node) stack.pop();
			System.out.print((char) node.getKey() + " ");
			if(node.right != null) {
				node = node.right;
				stack.push(node);
			}
		}
		*/
	}
	/**POST*/
	void postorder(Node root) {
		if(root!= null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print((char)root.getKey()+ " ");
		}
	}
	void postorder() { postorder(this.root);}
	void stackpostorder() {
		StackLinkedList stack = new StackLinkedList();
		Node node = this.root;
		while(true) {
            while(node != null) {//most left
            		stack.push(node);//double insert
            		stack.push(node);
                node = node.left;
            }
            if(stack.peek()==null) return;//empty stack
            node = (Node) stack.pop();
            if(stack.peek()!=null && stack.peek() == node) node = node.right;//go to right child
            else {
            		System.out.print((char) node.getKey() + " "); 
            		node = null;
            }
        }
	}
	
	void makeParseTree(String s) {
		StackLinkedList stack = new StackLinkedList();
		for (char c : s.toCharArray()) {
			if(isOperator(c)) {
				Node node = new Node(c); 
				setCount(getCount() + 1);
				node.setRight((Node)stack.pop());
				node.setLeft((Node)stack.pop());
				stack.push(node);
			}
			else if(Character.isDigit(c)) {
				setCount(getCount() + 1);
				stack.push(new Node(c));
			}
		}
		this.setRoot((Node) stack.pop());
	}
	private boolean isOperator(int val) {
		if(val=='+'||val=='-'||val=='*'||val=='/') return true;
		return false;
	}
	/*GETTER SETTER*/
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
