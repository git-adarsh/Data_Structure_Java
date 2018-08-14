package com.dsj.gp;

import com.dsj.graphs.Graph_Creation_Adj_List;

/**
 * IMPORTANT: This algorithm is not optimized. It is an implementation of Prim's
 * algorithm in a simple manner just to illustrate its working.
 */
public class Prim_MST {

	final static int MAX_VALUE = Integer.MAX_VALUE;
	Graph_Creation_Adj_List graph_to_be_traversed;

	int[] weight;
	int[] parent;
	boolean[] arrOfVisitedNodes;

	int numOfVertices;

	public Prim_MST(Graph_Creation_Adj_List graph_to_be_traversed) {
		this.graph_to_be_traversed = graph_to_be_traversed;
		numOfVertices = graph_to_be_traversed.numberOfVertices;
		weight = new int[numOfVertices];
		parent = new int[numOfVertices];
		arrOfVisitedNodes = new boolean[numOfVertices];
		mst();
	}

	private void mst() {
		System.out.println("BEGINING PRIM'S MST...");

		// Initialize weights: Put MAX value at all indices.
		for (int i = 0; i < numOfVertices; i++) {
			weight[i] = MAX_VALUE;
		}

		final int[] indexOfMinWeight = { 0 };

		while (!areAllVisited()) {
			graph_to_be_traversed.adjList[indexOfMinWeight[0]].forEach(connectedNode -> {
				int arrIndex = graph_to_be_traversed.getIndexForThis(connectedNode.getVertexId());

				// Check if current node is already visited or has weight less
				// than that in weight array.
				if (isValidOperation(arrIndex, connectedNode)) {
					weight[arrIndex] = connectedNode.getEdgeWeight();
					parent[arrIndex] = indexOfMinWeight[0];
				}
			});

			// Mark this node as visited
			arrOfVisitedNodes[indexOfMinWeight[0]] = true;

			// Get next min
			indexOfMinWeight[0] = getIndexOfMinItem();
		}
		printMST();
	}

	private void printMST() {
		for (int i = 1; i < numOfVertices; i++) {
			System.out.println(
					graph_to_be_traversed.arrIndexToVertexMap.get(parent[i]) + "====" + graph_to_be_traversed.arrIndexToVertexMap.get(i));
		}
	}

	/**
	 * @param arrIndex
	 *            index of current neighbor
	 * @param connectedNode
	 *            Weight-object containing representing current vertex
	 * @return boolean variable based on whether this node has been visited and
	 *         has weight lesser than in the weight array.
	 */
	private boolean isValidOperation(int arrIndex, WeightedNode connectedNode) {
		return !arrOfVisitedNodes[arrIndex] && weight[arrIndex] > connectedNode.getEdgeWeight();
	}

	/**
	 * @return the index of the item which has minimum value in the weight array
	 *         with the condition that it has not been visited.
	 */
	private int getIndexOfMinItem() {
		int min = weight[0];
		int minIndex = 0;
		for (int i = 1; i < numOfVertices; i++) {
			if (min > weight[i] && !arrOfVisitedNodes[i]) {
				min = weight[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	/**
	 * @return boolean variable based on whether all vertices have been visited.
	 */
	private boolean areAllVisited() {
		for (int i = 1; i < numOfVertices; i++) {
			if (!arrOfVisitedNodes[i]) {
				return false;
			}
		}
		return true;
	}
}