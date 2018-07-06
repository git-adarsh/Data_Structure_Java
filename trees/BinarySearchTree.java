package ds.trees;

import java.util.ArrayList;
import java.util.List;

import ds.node.Prev_Node_Next;

/**
 * The next field of Prev_Node_Next is treated as right child and the prev field
 * is treated as the left child.
 */
public class BinarySearchTree<T> {
	Prev_Node_Next<T> root;
	List<T> listForDelPurpose = new ArrayList<T>();
	Prev_Node_Next<T> parent;
	Prev_Node_Next<T> toBeProcessedNode;

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
		/*
		 * If new node's element is greater than element in parent, insert as
		 * right child; else, as left child.
		 */
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
		listForDelPurpose.add(dataInNode);
		insert(root, dataInNode);
	}

	public void deleteNode(T data) {
		if (isEmpty()) {
			System.out.println("Deletion cannot be performed. The tree is empty.");
			return;
		}

		if (!listForDelPurpose.stream().anyMatch(d -> d.equals(data))) {
			System.out.println("Deletion cannot be performed. The tree doesn't have this data.");
			return;
		}
		root = delete(root, data);
	}

	private Prev_Node_Next<T> delete(Prev_Node_Next<T> ref, T data) {
		int compareVal = compare(ref.getDataInNode(), data);
		// If parent has greater node value
		if (compareVal == 1) {
			ref.setPrev(delete(ref.getPrev(), data));
		}
		// if parent has lesser node value
		else if (compareVal == 0) {
			ref.setNext(delete(ref.getNext(), data));
		}
		// If parent's node value and input data are same.
		else {
			// If the node has one or no child
			if (ref.getNext() == null) {
				return ref.getPrev();
			}
			if (ref.getPrev() == null) {
				return ref.getNext();
			}

			// If the node has both children
			ref.setDataInNode(minData(ref.getNext()));

			ref.setNext(delete(ref.getNext(), ref.getDataInNode()));
		}
		return ref;

	}

	private T minData(Prev_Node_Next<T> ref) {
		while (ref.getPrev() != null) {
			ref = ref.getPrev();
		}
		return ref.getDataInNode();
	}

	public void inorderTraversal() {
		if (isEmpty()) {
			System.out.println("Nothing to show. The tree is empty.");
			return;
		}
		System.out.println("Inorder traversal begins.");
		inorder(root);
		System.out.println("Inorder traversal ends.");
	}

	public void preorderTraversal() {
		if (isEmpty()) {
			System.out.println("Nothing to show. The tree is empty.");
			return;
		}
		System.out.println("Preorder traversal begins.");
		preorder(root);
		System.out.println("Preorder traversal ends.");
	}

	public void postOrderTraversal() {
		if (isEmpty()) {
			System.out.println("Nothing to show. The tree is empty.");
			return;
		}
		System.out.println("Postorder traversal begins.");
		postorder(root);
		System.out.println("Postorder traversal ends.");
	}

	private void postorder(Prev_Node_Next<T> parent) {
		if (parent.getNext() != null) {
			postorder(parent.getNext());
		}
		if (parent.getPrev() != null) {
			postorder(parent.getPrev());
		}
		System.out.println(parent.getDataInNode());
	}

	private void inorder(Prev_Node_Next<T> parent) {
		if (parent.getPrev() != null) {
			inorder(parent.getPrev());
		}
		System.out.println(parent.getDataInNode());

		if (parent.getNext() != null) {
			inorder(parent.getNext());
		}

	}

	private void preorder(Prev_Node_Next<T> parent) {
		System.out.println(parent.getDataInNode());

		if (parent.getPrev() != null) {
			preorder(parent.getPrev());
		}

		if (parent.getNext() != null) {
			preorder(parent.getNext());
		}
	}

	/**
	 * Height of the tree
	 */
	public void findHeightOfTheTree() {
		if (isEmpty()) {
			System.out.println("The tree is empty.");
			return;
		}
		System.out.println("Height: " + height(root));
	}

	private int height(Prev_Node_Next<T> parent) {
		int leftHeight = 0;
		int rightHeight = 0;

		if (parent.getPrev() != null) {
			leftHeight = leftHeight + height(parent.getPrev());
		}

		if (parent.getNext() != null) {
			rightHeight = rightHeight + height(parent.getNext());
		}

		if (rightHeight > leftHeight) {
			return rightHeight + 1;
		} else {
			return leftHeight + 1;
		}
	}

	/**
	 * Compare the elements of current parent and new node
	 */
	public int compare(T parentData, T inputData) {
		int result = -1;

		if (parentData instanceof String) {
			if (((String) parentData).length() > ((String) inputData).length()) {
				result = 1;
			} else if (((String) parentData).length() < ((String) inputData).length()) {
				result = 0;
			}
		}

		if (parentData instanceof Number) {
			if (((Number) parentData).doubleValue() > ((Number) inputData).doubleValue()) {
				result = 1;
			} else if (((Number) parentData).doubleValue() < ((Number) inputData).doubleValue()) {
				result = 0;
			}
		}
		// result will contain -1 if both values are same.
		return result;
	}
}
