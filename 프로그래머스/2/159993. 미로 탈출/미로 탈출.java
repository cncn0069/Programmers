import java.util.*;

class Solution {
    class Node {
        int y, x, dis; // y: 행, x: 열
        public Node(int y, int x, int dis) {
            this.y = y;
            this.x = x;
            this.dis = dis;
        }
    }

    public boolean isSafe(int y, int x, int n, int m, boolean[][] wall) {
        return y >= 0 && y < n && x >= 0 && x < m && !wall[y][x];
    }

    public int solution(String[] maps) {
        int answer = -1;
        int n = maps.length;    // 행의 개수
        int m = maps[0].length(); // 열의 개수
        
        Node start = null, lever = null, end = null;
        boolean[][] wall = new boolean[n][m];

        // 좌표 초기화 (y: 행, x: 열)
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                char c = maps[y].charAt(x);
                if (c == 'S') start = new Node(y, x, 0);
                else if (c == 'L') lever = new Node(y, x, 0);
                else if (c == 'E') end = new Node(y, x, 0);
                else if (c == 'X') wall[y][x] = true;
            }
        }

        // 레버까지 BFS
        int toLever = bfs(start, lever, wall, n, m);
        if (toLever == -1) return -1;
        
        // 출구까지 BFS
        int toEnd = bfs(lever, end, wall, n, m);
        return toEnd == -1 ? -1 : toLever + toEnd;
    }

    private int bfs(Node start, Node target, boolean[][] wall, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<Node> que = new LinkedList<>();
        que.offer(start);
        visited[start.y][start.x] = true;

        int[] dy = {-1, 1, 0, 0}; // 상하좌우 y 이동 (행)
        int[] dx = {0, 0, -1, 1}; // 상하좌우 x 이동 (열)

        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.y == target.y && node.x == target.x) {
                return node.dis;
            }
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (isSafe(ny, nx, n, m, wall) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    que.offer(new Node(ny, nx, node.dis + 1));
                }
            }
        }
        return -1;
    }
}
