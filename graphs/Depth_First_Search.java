package com.dsj.graphs;

import java.util.Stack;

public class Depth_First_Search {
	Graph_Creation_Adj_List graph_to_be_searched;
	boolean[] visitedNodeTrackerArr;
	Stack<Integer> stack;

	public Depth_First_Search(Graph_Creation_Adj_List graph_to_be_searched) {
		this.graph_to_be_searched = graph_to_be_searched;
		dfs();
		System.out.println("DFS completed..");
	}

	private void dfs() {
		stack = new Stack<Integer>();
		int totalNodes = graph_to_be_searched.numberOfVertices;
		visitedNodeTrackerArr = new boolean[totalNodes];

		System.out.println("Begining DFS.....");
		updateNodeStatus(0);
		if (!stack.isEmpty()) {
			traverse(stack.peek());
		}

	}

	void updateNodeStatus(int index) {
		System.out.println(graph_to_be_searched.arrIndexToVertexMap.get(index));
		visitedNodeTrackerArr[index] = true;
		insertLinkedNodes(index);
	}

	private void traverse(Integer index) {
		if (isVisited(index) || stack.isEmpty()) {
			return;
		}
		int temp = stack.pop();
		updateNodeStatus(temp);
		if (!stack.isEmpty()) {
			traverse(stack.peek());
		}
	}

	private void insertLinkedNodes(int temp) {
		graph_to_be_searched.adjList[temp].forEach(connectedNode -> {
			int indexForVal = graph_to_be_searched.getIndexForThis(connectedNode.getVertexId());
			if (!isVisited(indexForVal)) {
				if (!stack.contains(indexForVal))
					stack.push(indexForVal);
			}
		});
	}

	private boolean isVisited(int index) {
		return visitedNodeTrackerArr[index];
	}
}
