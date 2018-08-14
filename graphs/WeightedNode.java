package com.dsj.graphs;

public class WeightedNode {
	String vertexId;
	int edgeWeight;

	public WeightedNode(String vertexId, int numOfVertices) {
		this.vertexId = vertexId;
		this.edgeWeight = numOfVertices;

	}

	public String getVertexId() {
		return vertexId;
	}

	public void setVertexId(String vertexId) {
		this.vertexId = vertexId;
	}

	public int getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(int edgeWeight) {
		this.edgeWeight = edgeWeight;
	}

}
