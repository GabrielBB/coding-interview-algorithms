package com.github.gabrielbb.algorithms;

import java.util.*;

public class ShortestPath {

	public static class Graph {

		private final List<Integer>[] nodes;

		@SuppressWarnings("unchecked")
		public Graph(int size) {
			nodes = new List[size];

			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new LinkedList<>();
			}
		}

		public void addEdge(int src, int dest) {
			// Representing undirected graph
			nodes[src].add(dest);
			nodes[dest].add(src);
		}

		public LinkedList<Integer> getShortestPath(int src, int dest) {

			int[] predecessors = new int[nodes.length];
			if (findPath(src, dest, predecessors)) {

				LinkedList<Integer> path = new LinkedList<>();
				path.add(dest);

				int curr = dest;
				while (curr != src) {
					curr = predecessors[curr];
					path.add(curr);
				}

				return path;
			}

			return null;
		}

		private boolean findPath(int src, int dest, int[] predecessors) {

			boolean[] visited = new boolean[nodes.length];
			visited[src] = true;

			Queue<Integer> q = new LinkedList<>();
			q.add(src);

			Integer curr;
			while ((curr = q.poll()) != null) {
				List<Integer> adjacents = nodes[curr];

				for (int node : adjacents) {
					if (!visited[node]) {
						visited[node] = true;
						predecessors[node] = curr;

						if (node == dest) {
							return true;
						}

						q.add(node);
					}
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {

		Graph g = new Graph(8);

		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		g.addEdge(5, 6);
		g.addEdge(6, 7);

		/*
		 * List<Integer> path = g.getShortestPath(0, 7);
		 * 
		 * if (path != null) { path.forEach(System.out::print); }
		 */

		LinkedList<Integer> path = g.getShortestPath(2, 6);

		if (path != null) {
			System.out.println("Shortest path size is: " + (path.size() - 1));

			while (!path.isEmpty()) {
				System.out.print(path.pollLast() + " ");
			}
		}
	}
}