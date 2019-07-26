package com.github.gabrielbb.bhacking;

import java.util.LinkedList;
import java.util.List;

public class GraphCycle {

    private static class Graph {

        private final List<Integer>[] nodes;

        private Graph(int size) {
            nodes = new List[size];

            for (int i = 0; i < size; i++) {
                nodes[i] = new LinkedList<>();
            }
        }

        private void addEdge(int src, int dest) {
            nodes[src].add(dest);
        }

        private boolean isCycling(int node, List<Integer> adjacents, boolean[] visited, boolean[] inStack) {

            if (inStack[node])
                return true;

            if (visited[node])
                return false;

            visited[node] = true;
            inStack[node] = true;

            for (int adjacent : adjacents)
                if (isCycling(adjacent, nodes[adjacent], visited, inStack))
                    return true;

            inStack[node] = false;

            return false;
        }

        private boolean detectCycle() {

            boolean[] visited = new boolean[nodes.length];
            boolean[] inStack = new boolean[nodes.length];

            for (int i = 0; i < nodes.length; i++)
                if (isCycling(i, nodes[i], visited, inStack))
                    return true;

            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(g.detectCycle() ? "CYCLE DETECTED!" : "NO CYCLES");
    }
}