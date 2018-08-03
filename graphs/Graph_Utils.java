package com.dsj.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph_Utils {

	Scanner sc;
	Map<Integer, String> arrIndexToVertexMap;

	int numberOfVertices;

	public Graph_Utils() {
		getNumberOfVertices();
	}

	void getNumberOfVertices() {
		sc = new Scanner(System.in);
		System.out.println("Enter the total number of vertices.");
		numberOfVertices = sc.nextInt();
	}

	/**
	 * Get the name of the vertices. Every thing that is entered is assumed
	 * taken-in as a string.
	 */
	void getVertices() {
		System.out.println("Enter your vertices:");
		arrIndexToVertexMap = new HashMap<>();
		try {
			for (int i = 0; i < numberOfVertices; i++) {
				arrIndexToVertexMap.put(i, sc.next());
			}
			sc.close();
		} catch (RuntimeException re) {
			System.out.println("Error at method:: getVertices || Description:" + re);
		}
	}

	/**
	 * @param vertex
	 *            Name of the vertex
	 * @return The unique index for this string from the hash-map.
	 */
	int getIndexForThis(String vertex) {
		int i = 0;
		for (; i < numberOfVertices; i++) {
			if (arrIndexToVertexMap.get(i).equalsIgnoreCase(vertex)) {
				break;
			}
		}
		return i;
	}
}
