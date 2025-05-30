import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        //n개의 노드가 있는 그래프
        //각 노드는 1 ~n까지 적혀있습니다.
        //1번 노드에서 가장 멀리 떨어진 ㄴ노드의 개수
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<= n ;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        int[] distance = new int[n + 1];
        for(int i = 0; i < distance.length;i++){
            distance[i] = 0;
        }
        boolean[] visited = new boolean[n+1];
        
        for(int[] index : edge){
            adj.get(index[0]).add(index[1]);
            adj.get(index[1]).add(index[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        
        que.offer(1);
        
        visited[1] = true;
        distance[1] = 0;
        while(!que.isEmpty()){
            int number = que.poll();
            for(int li : adj.get(number)){
                if(!visited[li]){
                    que.offer(li);
                    visited[li] = true;
                    distance[li] = distance[number] + 1;
                }
            }
           
        }
        int maxDistance = Arrays.stream(distance).max().getAsInt();
        int count = 0;
        for (int d : distance) {
            if (d == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}