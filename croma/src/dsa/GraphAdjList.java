package dsa;

import java.util.*;

/**
 * Undirected graph using adjacency list with BFS and DFS traversals.
 */
public class GraphAdjList {
	private final Map<Integer, List<Integer>> adj = new HashMap<>();

	public void addEdge(int u, int v) {
		adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
		adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
	}

	public List<Integer> bfs(int start) {
		List<Integer> order = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start); visited.add(start);
		while (!q.isEmpty()) {
			int u = q.poll();
			order.add(u);
			for (int v : adj.getOrDefault(u, Collections.emptyList())) {
				if (visited.add(v)) q.add(v);
			}
		}
		return order;
	}

	public List<Integer> dfs(int start) {
		List<Integer> order = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			int u = stack.pop();
			if (!visited.add(u)) continue;
			order.add(u);
			List<Integer> neighbors = new ArrayList<>(adj.getOrDefault(u, Collections.emptyList()));
			Collections.reverse(neighbors);
			for (int v : neighbors) stack.push(v);
		}
		return order;
	}

	public static void main(String[] args) {
		GraphAdjList g = new GraphAdjList();
		g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 2); g.addEdge(2, 3);
		System.out.println("BFS from 2: " + g.bfs(2));
		System.out.println("DFS from 2: " + g.dfs(2));
	}
}


