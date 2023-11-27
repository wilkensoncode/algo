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

class Main {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("p2", List.of("p0", "p3"));
        graph.put("p1", List.of("p0", "p2"));
        graph.put("p3", List.of("p1"));

        System.out.println(isCyclic(graph));

    }

    private static boolean isCyclic(Map<String, List<String>> graph) {

        Set<String> visitedSet = new HashSet<>();
        Stack<String> stack = new Stack<>();

        if (graph.isEmpty()) {
            return false;
        }

        for (String node : graph.keySet()) {
            if (isCyclicUtil(graph, visitedSet, stack, node)) {
                return true;
            }
        }
        return false;

    }

    private static boolean isCyclicUtil(
            Map<String, List<String>> graph,
            Set<String> visited,
            Stack<String> stack, String node) {

        if (stack.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        if (graph.containsKey(node)) {
            stack.push(node);
            for (String neighbor : graph.get(node)) {
                if (isCyclicUtil(graph, visited, stack, neighbor)) {
                    return true;
                }
            }
            stack.pop();
        }

        return false;
    }

}