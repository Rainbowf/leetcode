package offer2;

import java.util.*;
//课程表（拓扑排序）
class Solution113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //构建图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new LinkedList<Integer>());
        }

        int[] inDegrees = new int[numCourses];
        for (int[] temp : prerequisites) {
            graph.get(temp[1]).add(temp[0]);
            inDegrees[temp[0]]++;
        }
        //添加所有入度为0的点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        //
        List<Integer> order = new LinkedList<>();
        while (!queue.isEmpty()) {
            int course = queue.remove();
            order.add(course);

            for (int next : graph.get(course)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return order.size() == numCourses ? order.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}