import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {
    
    public static List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            inDegree[to]++;
        }

        Queue<Integer> zeroInDegreeQueue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                zeroInDegreeQueue.offer(i);
            }
        }
        
        List<Integer> topologicalOrder = new ArrayList<>();
        while(!zeroInDegreeQueue.isEmpty()) {
            int u = zeroInDegreeQueue.poll();
            topologicalOrder.add(u);

            if(graph.containsKey(u)) {
                for(int v : graph.get(u)) {
                    inDegree[v]--;
                    if(inDegree[v] == 0) {
                        zeroInDegreeQueue.offer(v);
                    }
                }
            }
        }

        if(topologicalOrder.size() != numCourses) {
            return new ArrayList<>();
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
        List<Integer> result = topologicalSort(numCourses, prerequisites);
        System.out.println("Topological order: " + result);
    }
}
