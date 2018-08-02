package com.dsj.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph_Creation_Adj_Matrix<T> {

	Scanner sc;
	Map<T, Integer> arrIndexToVertexMap;

	int numberOfVertices;
	int[][] adjMatrix;

	public Graph_Creation_Adj_Matrix() {
		getNumberOfVertices();
		adjMatrix = new int[numberOfVertices][numberOfVertices];
		getVertices();
	}

	@SuppressWarnings("unchecked")
	private void getVertices() {
		System.out.println("Enter your vertices:");
		arrIndexToVertexMap = new HashMap<>();
		for (int i = 0; i < numberOfVertices; i++) {
			arrIndexToVertexMap.put((T)sc.next(),i);
		}
	}

	public void isEdgeFromTo(T from, T to) {
		int v1 = arrIndexToVertexMap.get(from.toString());
		int v2 = arrIndexToVertexMap.get(to.toString());
		if (adjMatrix[v1][v2] == 1) {
			System.out.println("An edge exists between supplied vertices.");
		} else {
			System.out.println("An edge doesn't exist between supplied vertices.");
		}
	}

	public void addAnEdge(T from, T to) {
		int v1 = arrIndexToVertexMap.get(from.toString());
		int v2 = arrIndexToVertexMap.get(to.toString());
		if (adjMatrix[v1][v2] == 1) {
			System.out.println("An Edge already exists from " + from + " to " + to + ".");
			return;
		}
		adjMatrix[v1][v2] = 1;
	}

	public void removeEdge(int from, int to) {
		if (adjMatrix[from][to] == 0) {
			System.out.println("There is no edge from " + from + " to " + to + " to remove.");
			return;
		}
	}

	public void getNumberOfVertices() {
		sc = new Scanner(System.in);
		System.out.println("Enter the total number of vertices.");
		numberOfVertices = sc.nextInt();
	}
}
