package com.dsj.linklist;

import com.dsj.node.Prev_Node_Next;

public class DoublyLinkList<T> {

	Prev_Node_Next<T> start;
	Prev_Node_Next<T> end;

	public DoublyLinkList() {
		start = null;
		end = null;
	}

	/**
	 * @param dataInNode
	 *            Data to be inserted in the data field of node.
	 * @return A node with initialized with both reference field to NULL and data
	 *         field as @dataInNode.
	 */
	private Prev_Node_Next<T> getNewNode(T dataInNode) {
		return new Prev_Node_Next<T>(dataInNode);
	}

	/**
	 * @return List is empty or not.
	 */
	public boolean isEmpty() {
		return start == null;
	}

	/**
	 * @param data
	 *            Make a new entry at the beginning of the list with data
	 *            as @dataInNode
	 */
	public void insertAtBegining(T data) {
		Prev_Node_Next<T> node = getNewNode(data);

		if (start == null) {
			start = end = node;
			return;
		}

		node.setNext(start);
		start.setPrev(node);
		start = node;
	}

	/**
	 * @param data
	 *            Make a new entry at the end of the list with data as @dataInNode
	 */
	public void insertAtEnd(T data) {
		Prev_Node_Next<T> node = getNewNode(data);

		if (start == null) {
			start = end = node;
			return;
		}

		end.setNext(node);
		node.setPrev(end);
		end = node;
	}

	/**
	 * Delete first node in the List
	 * 
	 * @return The data contained in the list.
	 */
	public T deleteFirstNode() {
		T tempCheck = doPremDelCheck();
		if (tempCheck == null || start == null) {
			return tempCheck;
		}

		Prev_Node_Next<T> tempPtr = start;

		start = start.getNext();
		start.setPrev(null);

		return tempPtr.getDataInNode();
	}

	/**
	 * Delete last node in the List
	 * 
	 * @return The data contained in the list.
	 */
	public T deleteLastNode() {
		T tempCheck = doPremDelCheck();
		if (tempCheck == null || start == null) {
			return tempCheck;
		}

		Prev_Node_Next<T> tempPtr = end;

		end = end.getPrev();
		end.setNext(null);

		return tempPtr.getDataInNode();
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

	/**
	 * Reverse the list
	 * 
	 */
	public void reverse() {

		if (isEmpty()) {
			System.out.println("Reverse operation cannot be performed as the list is empty.\n");
			return;
		}

		if (start == end) {
			System.out.println("Reverse operation cannot be performed as the list contains only one item.\n");
			return;
		}

		Prev_Node_Next<T> tempPrev = null;

		end = start;
		while (start != null) {
			start.setPrev(start.getNext());
			start.setNext(tempPrev);
			tempPrev = start;
			start = start.getPrev();
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

		if (start.getNext() == null) {
			System.out.println(start.getDataInNode());
			return;
		}

		Prev_Node_Next<T> tempPtr = start;

		while (tempPtr.getNext() != null) {
			System.out.print(tempPtr.getDataInNode() + "->");
			tempPtr = tempPtr.getNext();
		}
		System.out.print(tempPtr.getDataInNode() + "\n");
	}

}
