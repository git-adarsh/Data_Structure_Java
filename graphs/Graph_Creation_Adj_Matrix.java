package com.dsj.graphs;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Implementation of an undirected-cyclic-graph
 * 
 * IMPORTANT: This code assumes that the name of the vertices are unique.
 */

public class Graph_Creation_Adj_Matrix {

	Scanner sc;
	Map<Integer, String> arrIndexToVertexMap;

	int numberOfVertices;
	int[][] adjMatrix;

	public Graph_Creation_Adj_Matrix() {
		getNumberOfVertices();
		adjMatrix = new int[numberOfVertices][numberOfVertices];
		getVertices();
	}

	/**
	 * Get the name of the vertices. Every thing that is entered is assumed
	 * taken-in as a string.
	 */
	private void getVertices() {
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

	private void getNumberOfVertices() {
		sc = new Scanner(System.in);
		System.out.println("Enter the total number of vertices.");
		numberOfVertices = sc.nextInt();
	}

	/**
	 * Check if there is an edge or relationship(assumed to be friends) between
	 * supplied vertices.
	 * 
	 * @param from
	 *            Vertex 1
	 * @param to
	 *            Vertex 1
	 */
	public void isEdgeFromTo(String from, String to) {
		int v1 = getIndexForThis(from);
		int v2 = getIndexForThis(to);
		if (adjMatrix[v1][v2] == 1) {
			System.out.println("These two persons are friends.");
		} else {
			System.out.println("These two persons are not friends..");
		}
	}

	/**
	 * Add an edge or establish a relationship between two vertices.
	 * 
	 * @param from
	 *            Vertex 1
	 * @param to
	 *            Vertex 2
	 */
	public void addAnEdge(String from, String to) {
		int v1 = getIndexForThis(from);
		int v2 = getIndexForThis(to);
		if (adjMatrix[v1][v2] == 1) {
			System.out.println(MessageFormat.format("{0} and {1} this are friends already.", from, to));
			return;
		}
		adjMatrix[v1][v2] = 1;
		adjMatrix[v2][v1] = 1;
		System.out.println(MessageFormat.format("{0}, you are now friends with {1}.", from, to));
	}

	/**
	 * Remove the edge or relationship between the supplied nodes.
	 * 
	 * @param from
	 *            Vertex 1
	 * @param to
	 *            Vertex 2
	 */
	public void removeEdge(String from, String to) {
		int v1 = getIndexForThis(from);
		int v2 = getIndexForThis(to);
		if (adjMatrix[v1][v2] == 0) {
			System.out.println(MessageFormat.format("{0} and {1} aren't friends.)", from, to));
			return;
		} else {
			adjMatrix[v1][v2] = 0;
			adjMatrix[v2][v1] = 0;
			System.out.println("Unfriended.");

		}
	}

	/**
	 * SHow all the vertices(friends) connected to this vertex and all the
	 * indirectly connected(mutual friends) of this node.
	 * 
	 * @param vertex
	 * 
	 */
	public void getVertexInfo(String vertex) {
		int index = getIndexForThis(vertex);
		showConnectedVertices(index);
		showMutualVertices(index);
	}

	/**
	 * @param vertex
	 *            Name of the vertex
	 * @return The unique index for this string from the hash-map.
	 */
	private int getIndexForThis(String vertex) {
		int i = 0;
		for (; i < numberOfVertices; i++) {
			if (arrIndexToVertexMap.get(i).equalsIgnoreCase(vertex)) {
				break;
			}
		}
		return i;
	}

	/**
	 * Show all vertices connected to this vertex.
	 * 
	 * @param index
	 */
	private void showConnectedVertices(int index) {
		System.out.println(MessageFormat.format("{0}, your friends are: ", arrIndexToVertexMap.get(index)));
		String separator = "";
		for (int j = 0; j < numberOfVertices; j++) {
			if (index == j) {
				continue;
			}
			if (adjMatrix[index][j] == 1) {
				System.out.print(separator);
				System.out.print(arrIndexToVertexMap.get(j));
				separator = ", ";
			}

		}
		System.out.println();
	}

	/**
	 * Show all mutual vertices for the supplied vertex and all other vertices.
	 * 
	 * @param index
	 *            The index from the map for the supplied vertex.
	 */
	private void showMutualVertices(int index) {
		for (int i = 0; i < numberOfVertices; i++) {
			if (index == i) {
				continue;
			}
			getMutualForTheseTwo(index, i);
		}
	}

	private void getMutualForTheseTwo(int index1, int index2) {
		List<Integer> mutualVerticesIndex = new ArrayList<>();
		final String[] separator = { "" };
		for (int i = 0; i < numberOfVertices; i++) {
			if (index1 == i || index2 == i) {
				continue;
			}
			if (adjMatrix[index1][i] == 1 && adjMatrix[index2][i] == 1) {
				mutualVerticesIndex.add(i);
			}
		}
		if (!mutualVerticesIndex.isEmpty()) {
			System.out.println(MessageFormat.format("The mutual friends for {0} and {1} are: ", arrIndexToVertexMap.get(index1),
					arrIndexToVertexMap.get(index2)));
			mutualVerticesIndex.forEach(index -> {
				System.out.print(separator[0] + arrIndexToVertexMap.get(index));
				separator[0] = ", ";
			});
			System.out.println();
		}
	}
}
