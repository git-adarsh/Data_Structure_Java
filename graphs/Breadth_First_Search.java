package com.dsj.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Breadth_First_Search {

	Queue<Integer> queue;
	Graph_Creation_Adj_List graph_to_be_searched;

	boolean visitedVertexArr[];
	int numberOfVertices;

	public Breadth_First_Search(Graph_Creation_Adj_List graph_to_be_searched) {
		this.graph_to_be_searched = graph_to_be_searched;
		queue = new LinkedList<Integer>();
		bfs();
	}

	private void bfs() {
		System.out.println("BFS begins.");
		numberOfVertices = graph_to_be_searched.numberOfVertices;
		visitedVertexArr = new boolean[numberOfVertices];
		updateVertexStatus(0);
		traverse(queue.peek());
		System.out.println("BFS Completed.");
	}

	private void traverse(int index) {
		int temp = queue.remove();
		updateVertexStatus(temp);
		if (!queue.isEmpty()) {
			traverse(queue.peek());
		}
	}

	private void updateVertexStatus(int index) {
		System.out.println(graph_to_be_searched.arrIndexToVertexMap.get(index));
		visitedVertexArr[index] = true;
		insertAdjVertices(index);
	}

	private void insertAdjVertices(int index) {
		graph_to_be_searched.adjList[index].forEach(connectedNodes -> {
			int temp = graph_to_be_searched.getIndexForThis(connectedNodes.getVertexId());
			if (!visitedVertexArr[temp]) {
				if (!queue.contains(temp)) {
					queue.add(temp);
				}
			}
		});
	}
}
