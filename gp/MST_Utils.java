package com.dsj.gp;

import java.util.Scanner;

public class MST_Utils {

	int numOfVertices;
	int[] vertices;

	Scanner sc;

	public MST_Utils() {
		sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		numOfVertices = sc.nextInt();
		vertices = new int[numOfVertices];
		takeVertices();
	}

	public void takeVertices() {
		System.out.println("Enter your vertices");
		int j = 0;
		for (int i = 0; i < numOfVertices / 2; i++) {
			vertices[j] = sc.nextInt();
			if (++j == numOfVertices) {
				break;
			}
			vertices[j] = sc.nextInt();
			if (++j == numOfVertices) {
				break;
			}
			vertices[j] = sc.nextInt();
			j++;
		}
		sc.close();
	}
}
