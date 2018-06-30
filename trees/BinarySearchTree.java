package com.dsj.trees;

import com.dsj.node.Prev_Node_Next;

/**
 * The next field of Prev_Node_Next is treated as right child and the prev field
 * is treated as the left child.
 */
public class BinarySearchTree<T> {
	Prev_Node_Next<T> root;

	public BinarySearchTree() {
		root = null;
	}
	/**
	 * @param dataInNode
	 *            Data in the node. Can be an instance of a number or a string
	 * @return A new Prev_Node_Next object
	 */
	private Prev_Node_Next<T> getNewNode(T dataInNode) {
		return new Prev_Node_Next<T>(dataInNode);
	}
	private void insert(Prev_Node_Next<T> parent, T dataInNode) {
		if (isEmpty()) {
			Prev_Node_Next<T> node = getNewNode(dataInNode);
			root = parent = node;
			return;
		}
		// If new node's element is greater than element in parent,
		// insert as right child; else, as left child.
		if (compare(parent.getDataInNode(), dataInNode) != 1) {
			if (parent.getNext() != null) {
				parent = parent.getNext();
				insert(parent, dataInNode);
			} else {
				Prev_Node_Next<T> node = getNewNode(dataInNode);
				parent.setNext(node);
			}
		} else {
			if (parent.getPrev() != null) {
				parent = parent.getPrev();
				insert(parent, dataInNode);
			} else {
				Prev_Node_Next<T> node = getNewNode(dataInNode);
				parent.setPrev(node);
			}
		}
	}
	private boolean isEmpty() {
		return root == null;
	}

	public void insertNewNode(T dataInNode) {
		insert(root, dataInNode);
	}

	public void inorderTraversal() {
		inorder(root);
	}

	public void preorderTraversal() {
		preorder(root);
	}

	public void postOrderTraversal() {
		postorder(root);
	}

	private void postorder(Prev_Node_Next<T> parent) {
		if (isEmpty()) {
			System.out.println("Nothing to show. The tree is empty.");
			return;
		}
		if (parent.getNext() != null) {
			postorder(parent.getNext());
		}
		if (parent.getPrev() != null) {
			postorder(parent.getPrev());
		}
		System.out.println(parent.getDataInNode());
	}

	private void inorder(Prev_Node_Next<T> parent) {

		if (isEmpty()) {
			System.out.println("Nothing to show. The tree is empty.");
			return;
		}
		if (parent.getPrev() != null) {
			inorder(parent.getPrev());
		}
		System.out.println(parent.getDataInNode());

		if (parent.getNext() != null) {
			inorder(parent.getNext());
		}

	}

	private void preorder(Prev_Node_Next<T> parent) {
		if (isEmpty()) {
			System.out.println("Nothing to show. The tree is empty.");
			return;
		}
		System.out.println(parent.getDataInNode());
		
		if (parent.getPrev() != null) {
			preorder(parent.getPrev());
		}

		if (parent.getNext() != null) {
			preorder(parent.getNext());
		}
	}

	/**
	 * Compare the elements of current parent and new node
	 */
	public int compare(T parentData, T newNodeData) {
		int result = 0;

		if (parentData instanceof String) {
			if (((String) parentData).length() > ((String) newNodeData).length()) {
				result = 1;
				return result;
			}
		}

		if (parentData instanceof Number) {
			if (((Number) parentData).doubleValue() > ((Number) newNodeData).doubleValue()) {
				result = 1;
				return result;
			}
		}
		return result;
	}
}
