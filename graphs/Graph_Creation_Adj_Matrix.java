package com.dsj.graphs;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of an undirected-cyclic-graph using adjacency-matrix.
 * 
 * IMPORTANT: This code assumes that the name of the vertices are unique.
 */

public class Graph_Creation_Adj_Matrix extends Graph_Utils {

	int[][] adjMatrix;

	public Graph_Creation_Adj_Matrix() {
		super();
		adjMatrix = new int[numberOfVertices][numberOfVertices];
		getVertices();
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
			System.out.println(MessageFormat.format("{0} and {1} are friends.", from, to));
		} else {
			System.out.println(MessageFormat.format("{0} and {1} are not friends.", from, to));
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
	 * Show all the vertices(friends) connected to this vertex and all the
	 * indirectly connected(mutual friends) of this node.
	 * 
	 */
	public void showVertexInfo(String vertex) {
		int index = getIndexForThis(vertex);

		if (!hasAnyFriend(index)) {
			System.out.println(vertex + ", you have not added any friends.");
			return;
		}
		showConnectedVertices(index);
		showMutualVertices(index);
	}

	/**
	 * @param index
	 *            Index of the vertex
	 * @return a boolean value based on whether this vertex has any
	 *         friend(connection).
	 */
	private boolean hasAnyFriend(int index) {
		boolean hasAnyFriend = false;
		for (int i = 0; i < numberOfVertices; i++) {
			if (adjMatrix[index][i] == 1) {
				hasAnyFriend = true;
				break;
			}
		}
		return hasAnyFriend;
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
			System.out.println(MessageFormat.format("{0}, your mutual friends with {1} are: ", arrIndexToVertexMap.get(index1),
					arrIndexToVertexMap.get(index2)));
			mutualVerticesIndex.forEach(index -> {
				System.out.print(separator[0] + arrIndexToVertexMap.get(index));
				separator[0] = ", ";
			});
			System.out.println();
		}
	}
}
