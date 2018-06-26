package com.dsj.stacks;

import com.dsj.linklist.SinglyLinkList;

public class Stack<T> extends SinglyLinkList<T> {

	public Stack() {
		super();
	}

	/**
	 * Return the data of node at TOP of stack.
	 */
	public T peek() {
		if (isEmpty()) {
			System.out.println("The stack is empty.");
			return null;
		}

		return end.getDataInNode();
	}

	/**
	 * Insert a node.
	 */
	public void push(T data) {
		super.insertAtEnd(data);
	}

	/**
	 * Delete the node at TOP of stack.
	 */
	public T pop() {
		return super.deleteLastNode();
	}
}
