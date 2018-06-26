package com.dsj.node;

public class Node_Next<T> {

	private T dataInNode;
	private Node_Next<T> ref;

	public Node_Next(T dataInNode) {
		this.dataInNode = dataInNode;
		this.ref = null;
	}

	public T getDataInNode() {
		return dataInNode;
	}

	public void setDataInNode(T dataInNode) {
		this.dataInNode = dataInNode;
	}

	public Node_Next<T> getRef() {
		return ref;
	}

	public void setRef(Node_Next<T> ref) {
		this.ref = ref;
	}

}
