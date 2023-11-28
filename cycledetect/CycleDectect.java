package cycledetect;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;

/**
 * Detect cycle in a directed graph
 * 321 algo course
 * 
 */

class CycleDetect {
    public static void main(String[] args) {
        // directed graph > string key, list of string neighbors
        Map<String, List<String>> graph = new HashMap<>();
        // add (k,v) pairs to graph
        graph.put("p2", List.of("p0", "p3"));
        graph.put("p1", List.of("p0", "p2"));
        graph.put("p3", List.of("p1"));

        System.out.println(isCyclic(graph));

    }

    private static boolean isCyclic(Map<String, List<String>> graph) {

        Set<String> visitedSet = new HashSet<>(); // visited nodes
        Stack<String> stack = new Stack<>(); // nodes in current path

        if (graph.isEmpty()) {
            return false; // no cycle in empty graph
        }

        for (String node : graph.keySet()) { // for each node in graph aka vertex
            if (isCyclicUtil(graph, visitedSet, stack, node)) { // if cycle found
                return true; // return true
            }
        }
        return false; // no cycle found

    }

    private static boolean isCyclicUtil( // helper method
            Map<String, List<String>> graph,
            Set<String> visited,
            Stack<String> stack, String node) {

        if (stack.contains(node)) { // if node is in current path (node already in stack -> cycle)
            return true;
        }

        if (visited.contains(node)) { // if node is already visited (node already in visitedSet -> no neighbors)
            return false;
        }

        visited.add(node); // add node to visitedSet

        if (graph.containsKey(node)) {
            stack.push(node); // add node to current path (stack)
            for (String neighbor : graph.get(node)) { // for each neighbor of node (vertex)
                if (isCyclicUtil(graph, visited, stack, neighbor)) { // if cycle found
                    return true;
                }
            }
            stack.pop(); // remove node from current path (stack) (no neighbors)
        }

        return false;
    }

}