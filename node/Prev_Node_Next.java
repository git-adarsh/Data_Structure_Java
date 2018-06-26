package com.dsj.node;

public class Prev_Node_Next<T> {

	private T dataInNode;
	private Prev_Node_Next<T> next;
	private Prev_Node_Next<T> prev;

	public Prev_Node_Next(T dataInNode) {
		this.dataInNode = dataInNode;
		this.next = null;
		this.prev = null;
	}

	public T getDataInNode() {
		return dataInNode;
	}

	public void setDataInNode(T dataInNode) {
		this.dataInNode = dataInNode;
	}

	public Prev_Node_Next<T> getNext() {
		return next;
	}

	public void setNext(Prev_Node_Next<T> next) {
		this.next = next;
	}

	public Prev_Node_Next<T> getPrev() {
		return prev;
	}

	public void setPrev(Prev_Node_Next<T> prev) {
		this.prev = prev;
	}

}
