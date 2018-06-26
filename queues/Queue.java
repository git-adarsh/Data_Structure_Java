package com.dsj.queues;

import com.dsj.linklist.SinglyLinkList;

public class Queue<T> extends SinglyLinkList<T> {

	public Queue() {
		super();
	}

	/**
	 * @param data
	 *            Make a new node with @data and insert at rear.
	 */
	public void insert(T data) {
		super.insertAtEnd(data);
	}

	/**
	 * Delete the node pointed at by "Front".
	 */
	public T delete() {
		return super.deleteFirstNode();
	}
}
