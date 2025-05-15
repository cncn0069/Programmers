import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n; // 최대 차이로 초기화

        // 각 전선을 하나씩 끊어보면서 시뮬레이션
        for (int i = 0; i < wires.length; i++) {
            // 인접 리스트 생성
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            // i번째 전선을 제외하고 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int v1 = wires[j][0];
                int v2 = wires[j][1];
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            // BFS로 한 쪽 네트워크의 송전탑 개수 구하기
            boolean[] visited = new boolean[n + 1];
            int count = bfs(1, graph, visited);

            // 두 네트워크의 송전탑 개수 차이 계산
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    // BFS로 연결된 송전탑 개수 세기
    private int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }
        return count;
    }
}
