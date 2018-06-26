package com.dsj.queues;

import com.dsj.linklist.SinglyLinkList;

public class DeQueue<T> extends SinglyLinkList<T>{
	
	public DeQueue() {
		super();
	}
	
	/**
	 * @param data
	 *            Make a new node with @data and insert at "Front".
	 */
	public void insertAtFront(T data) {
		super.insertAtBegining(data);
	}
	
	/**
	 * @param data
	 *            Make a new node with @data and insert at "Rear".
	 */
	public void insertAtRear(T data) {
		super.insertAtEnd(data);
	}
	/**
	 * Delete the node pointed at by "Rear".
	 */
	public T deleteFromRear() {
		return super.deleteLastNode();
	}
	/**
	 * Delete the node pointed at by "Front".
	 */
	public T deleteFromFront() {
		return super.deleteFirstNode();
	}
}


