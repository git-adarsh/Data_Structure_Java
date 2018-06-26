package com.dsj.linklist;

import com.dsj.node.Node_Next;
import com.dsj.queues.Queue;
import com.dsj.stacks.Stack;

public class SinglyLinkList<T> {
	protected Node_Next<T> start;
	protected Node_Next<T> end;

	public SinglyLinkList() {
		start = null;
		end = null;
	}

	/**
	 * @param dataInNode
	 *            Data to be inserted in the data field of node.
	 * @return A node with initialized with both reference field to NULL and data
	 *         field as @dataInNode.
	 */

	private Node_Next<T> getNewNode(T data) {
		Node_Next<T> node = new Node_Next<T>(data);
		return node;
	}

	/**
	 * @param data
	 *            Make a new entry at the beginning of the list with data
	 *            as @dataInNode
	 */
	public void insertAtBegining(T data) {

		if (this instanceof Stack || this instanceof Queue) {
			System.out.println("This operation is not permitted on " + this.getClass());
		}
		Node_Next<T> node = getNewNode(data);

		if (isEmpty()) {
			start = node;
			end = start;
			return;
		}

		node.setRef(start);
		start = node;
	}

	/**
	 * @param data
	 *            Make a new entry at the end of the list with data as @dataInNode
	 */
	public void insertAtEnd(T data) {
		Node_Next<T> node = getNewNode(data);

		if (isEmpty()) {
			start = node;
			end = start;
			return;
		}
		end.setRef(node);
		end = node;

	}

	/**
	 * @return List is empty or not.
	 */
	public boolean isEmpty() {
		return start == null;
	}

	/**
	 * @param val
	 *            Delete the node with this data
	 * @return return deleted data
	 */
	public T delete(T val) {

		if (!(this instanceof SinglyLinkList)) {
			System.out.println("This operation is not permitted on " + this.getClass());
			return null;
		}
		T tempCheck = doPremDelCheck();
		if (tempCheck == null || start == null) {
			return tempCheck;
		}

		Node_Next<T> prev = null;
		Node_Next<T> tempPtr = start;

		while (tempPtr.getDataInNode() != val) {
			prev = tempPtr;
			tempPtr = tempPtr.getRef();
		}

		if (prev == null) {
			start = start.getRef();
			return tempPtr.getDataInNode();
		}
		prev.setRef(tempPtr.getRef());

		return tempPtr.getDataInNode();
	}

	/**
	 * Delete first node in the List
	 * 
	 * @return The data contained in the list.
	 */
	final public T deleteFirstNode() {

		if (this instanceof Stack) {
			System.out.println("This operation is not permitted on Stacks.");
			return null;
		}

		T tempCheck = doPremDelCheck();
		if (tempCheck == null || start == null) {
			return tempCheck;
		}

		T tempData = start.getDataInNode();
		start = start.getRef();

		return tempData;
	}

	/**
	 * Delete last node in the List
	 * 
	 * @return The data contained in the list.
	 */
	public T deleteLastNode() {

		if (this instanceof Queue) {
			System.out.println("This operation is not permitted on a Queue.");
			return null;
		}
		T tempCheck = doPremDelCheck();
		if (tempCheck == null || start == null) {
			return tempCheck;
		}

		Node_Next<T> prev = null;
		Node_Next<T> tempPtr = start;

		while (tempPtr.getRef() != end) {
			prev = tempPtr;
			tempPtr = tempPtr.getRef();
		}

		T tempData = end.getDataInNode();

		if (prev == null) {
			start.setRef(null);
			end = start;
			return tempData;
		}

		end = prev.getRef();
		end.setRef(null);

		return tempData;
	}

	/**
	 * Check prerequisites before beginning of deletion.
	 * 
	 * @return Checked value
	 */
	private T doPremDelCheck() {

		if (isEmpty()) {
			System.out.println("There is no item in the list to delete.");
			return null;
		}

		T tempData = start.getDataInNode();

		if (start == end) {
			start = end = null;
			return tempData;
		}
		return tempData;
	}

	public void reverse() {
		if (!(this instanceof SinglyLinkList)) {
			System.out.println("This operationis not prmitted on class:" + this.getClass() + "\n");
			return;
		}

		if (isEmpty()) {
			System.out.println("Reverse operation cannot be performed as the list is empty.\n");
			return;
		}

		if (start == end) {
			System.out.println("Reverse operation cannot be performed as the list contains only one item.\n");
			return;
		}

		end = start;
		Node_Next<T> tempPtr = start;
		Node_Next<T> tempPrev = null;

		while (start != null) {
			tempPtr = start.getRef();
			start.setRef(tempPrev);
			tempPrev = start;
			start = tempPtr;
		}
		start = tempPrev;

	}

	/**
	 * Display all data in the list.
	 * 
	 */
	public void display() {
		if (start == null) {
			System.out.print("There are no items in the list.\n");
			return;
		}

		if (start.getRef() == null) {
			System.out.println(start.getDataInNode());
			return;
		}

		Node_Next<T> tempPtr = start;

		while (tempPtr.getRef() != null) {
			System.out.print(tempPtr.getDataInNode() + "->");
			tempPtr = tempPtr.getRef();
		}
		System.out.print(tempPtr.getDataInNode() + "\n");
	}
}