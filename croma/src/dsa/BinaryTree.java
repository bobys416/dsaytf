package dsa;

/**
 * Minimal binary search tree with insert and inorder traversal.
 */
public class BinaryTree {
	static class Node {
		int key;
		Node left, right;
		Node(int key) { this.key = key; }
	}

	Node root;

	public void insert(int key) { root = insertRec(root, key); }

	private Node insertRec(Node node, int key) {
		if (node == null) return new Node(key);
		if (key < node.key) node.left = insertRec(node.left, key);
		else if (key > node.key) node.right = insertRec(node.right, key);
		return node;
	}

	public void inorder() { inorderRec(root); System.out.println(); }

	private void inorderRec(Node node) {
		if (node == null) return;
		inorderRec(node.left);
		System.out.print(node.key + " ");
		inorderRec(node.right);
	}

	public boolean search(int key) { return searchRec(root, key) != null; }

	private Node searchRec(Node node, int key) {
		if (node == null || node.key == key) return node;
		return key < node.key ? searchRec(node.left, key) : searchRec(node.right, key);
	}

	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		int[] keys = {50, 30, 20, 40, 70, 60, 80};
		for (int k : keys) bst.insert(k);
		bst.inorder();
		System.out.println("Search 60: " + bst.search(60));
		System.out.println("Search 25: " + bst.search(25));
	}
}


