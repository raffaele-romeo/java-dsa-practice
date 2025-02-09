package graph;

import java.util.*;

public class GraphAlgorithms {
    public <T> Map<T, Integer> dijkstraShortestPath(T src, Map<T, List<Pair<T, Integer>>> graph) {
        if (graph == null) {
            throw new RuntimeException("Graph is null ");
        }

        if (!graph.containsKey(src)) {
            throw new RuntimeException("Src is not in graph");
        }

        PriorityQueue<Pair<T, Integer>> priorityQueue = new PriorityQueue<>(
                graph.size(),
                Comparator.comparingInt(Pair::getSecond)
        );
        priorityQueue.add(new Pair<>(src, 0));

        var distanceMapFromSrc = new HashMap<T, Integer>();

        for (T key : graph.keySet()) {
            distanceMapFromSrc.put(key, Integer.MAX_VALUE);
        }
        distanceMapFromSrc.put(src, 0);

        while (!priorityQueue.isEmpty()) {
            var currentPair = priorityQueue.poll();
            var currentNode = currentPair.getFirst();
            var currentNodeDistanceFromSrc = currentPair.getSecond();

            for (Pair<T, Integer> neighborPair : graph.get(currentNode)) {
                var neighbor = neighborPair.getFirst();
                var neighborWeight = neighborPair.getSecond();
                var newDistance = currentNodeDistanceFromSrc + neighborWeight;

                if (distanceMapFromSrc.get(neighbor) > newDistance) {
                    distanceMapFromSrc.put(neighbor, newDistance);
                    priorityQueue.add(new Pair<>(neighbor, newDistance));
                }
            }
        }

        return distanceMapFromSrc;
    }

    public <T> int shortestPath(T src, T dest, Map<T, List<T>> graph) {
        if (src.equals(dest)) {
            return 0;
        }

        if (graph == null) {
            throw new RuntimeException("Graph is null ");
        }

        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            throw new RuntimeException("Src or dest is not in graph");
        }

        var visited = new HashSet<>();
        visited.add(src);
        Queue<Pair<T, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<T, Integer>(src, 0));

        while (!queue.isEmpty()) {
            var currentPair = queue.poll();
            T currentNode = currentPair.getFirst();
            int currentDistance = currentPair.getSecond();

            for (T neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
                if (neighbor.equals(dest)) {
                    return currentDistance + 1;
                }

                if (!visited.contains(neighbor)) {
                    queue.add(new Pair<T, Integer>(neighbor, currentDistance + 1));
                    visited.add(neighbor);
                }
            }
        }

        return -1;
    }

    public <T> int largestComponent(Map<T, List<T>> graph) {
        var count = 0;
        Set<T> visited = new HashSet<>();

        for (T key : graph.keySet()) {
            if (!visited.contains(key)) {
                var component = exploreComponent(key, graph, visited);
                count = Math.max(count, component);
            }
        }

        return count;
    }

    private <T> int exploreComponent(T src, Map<T, List<T>> graph, Set<T> visited) {
        var count = 0;
        Stack<T> stack = new Stack<>();

        if (graph == null || !graph.containsKey(src)) {
            throw new RuntimeException("Source is not contained in the graph");
        }

        stack.push(src);

        while (!stack.isEmpty()) {
            var currentNode = stack.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                count++;

                for (T neighbour : graph.getOrDefault(currentNode, Collections.emptyList())) {
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }

            }
        }

        return count;
    }

    public <T> int connectedComponentCount(Map<T, List<T>> graph) {
        Set<T> visited = new HashSet<>();
        var count = 0;
        for (T key : graph.keySet()) {
            if (explorePath(graph, key, visited)) {
                count++;
            }
        }

        return count;
    }

    private <T> boolean explorePath(Map<T, List<T>> graph, T currentNode, Set<T> visited) {
        if (visited.contains(currentNode)) return false;

        visited.add(currentNode);

        for (T neighbour : graph.getOrDefault(currentNode, Collections.emptyList())) {
            explorePath(graph, neighbour, visited);
        }

        return true;
    }

    public <T> boolean hasPath(T src, T dest, Map<T, List<T>> graph) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        if (graph == null || !graph.containsKey(src)) {
            throw new RuntimeException("Source is not contained in the graph");
        }

        stack.push(src);

        while (!stack.isEmpty()) {
            var currentNode = stack.pop();

            if (currentNode.equals(dest)) {
                return true;
            }

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                for (T neighbour : graph.getOrDefault(currentNode, Collections.emptyList())) {
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }

            }
        }

        return false;
    }

    public List<Integer> bfs(int src, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        if (graph == null || !graph.containsKey(src)) {
            throw new RuntimeException("Source is not contained in the graph");
        }

        queue.add(src);

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                output.add(currentNode);

                for (Integer neighbour : graph.getOrDefault(currentNode, Collections.emptyList())) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                    }
                }

            }
        }

        return output;
    }

    public List<Integer> dfs(int src, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        if (graph == null || !graph.containsKey(src)) {
            throw new RuntimeException("Source is not contained in the graph");
        }

        stack.push(src);

        while (!stack.isEmpty()) {
            var currentNode = stack.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                output.add(currentNode);

                for (Integer neighbour : graph.getOrDefault(currentNode, Collections.emptyList())) {
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }

            }
        }

        return output;
    }

    public List<Integer> dfsRecursive(int src, Map<Integer, List<Integer>> graph) {
        if (graph == null || !graph.containsKey(src)) {
            throw new RuntimeException("Source is not contained in the graph");
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        dfsHelper(src, graph, visited, output);
        return output;
    }

    private void dfsHelper(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, List<Integer> output) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        output.add(node);

        for (Integer neighbour : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, graph, visited, output);
            }
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        var map = new HashMap<Integer, List<Integer>>();

        for (int[] edge : edges) {
            if (edge.length != 2) {
                throw new RuntimeException("Edge should contain src and dest");
            }

            var node1 = edge[0];
            var node2 = edge[1];

            addUndirectedEdge(map, node1, node2);
        }

        return map;
    }

    public void addUndirectedEdge(Map<Integer, List<Integer>> graph, int node1, int node2) {
        graph.putIfAbsent(node1, new ArrayList<>());
        graph.putIfAbsent(node2, new ArrayList<>());
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(1, 6));
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());
        graph.put(6, Collections.emptyList());
        graph.put(7, Collections.emptyList());

        GraphAlgorithms graphAlgorithms = new GraphAlgorithms();
        System.out.println(graphAlgorithms.dfsRecursive(1, graph));
        System.out.println(graphAlgorithms.dfs(1, graph));
        System.out.println(graphAlgorithms.bfs(1, graph));

        System.out.println(graphAlgorithms.hasPath(4, 6, graph));
        System.out.println(graphAlgorithms.connectedComponentCount(graph));
        System.out.println(graphAlgorithms.largestComponent(graph));
        System.out.println(graphAlgorithms.shortestPath(1, 5, graph));
    }
}
