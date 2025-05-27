import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=N;i++) adj.add(new ArrayList<>());
        for(int[] r : road){
            adj.get(r[0]).add(new int[]{r[1],r[2]});
            adj.get(r[1]).add(new int[]{r[0],r[2]});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{1,0});
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] > dist[cur[0]]) continue;
            for(int[] next : adj.get(cur[0])){
                if(dist[next[0]] > cur[1] + next[1]){
                    dist[next[0]] = cur[1] + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }
        return answer;

    }
}