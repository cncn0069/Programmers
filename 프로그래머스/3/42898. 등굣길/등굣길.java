import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        //가장 왼쪽 위 좌표는 (1,1)
        //가장 오른쪽 아래 (m,n)
        //물이 담긴 지역의 좌표
        //12345
        //12345
        //오른쪽과 아래쪽으로만 움직여야함
        // n = n(위) + n(왼)
        //0 1 1 1
        //1 2 3 4
        //1 3 6 10
        //최단 경로의 수
        int [][] map = new int[n][m];
        int [][] water = new int[n][m];
        
        for(int[] a:puddles){
            water[a[1]-1][a[0]-1] = 1;
        }
        
        map[0][0] = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m;j++){
                if(water[i][j] == 1){
                    map[i][j] = 0;
                    continue;
                }
                if(i>0) map[i][j] = (map[i][j] + map[i-1][j])%1000000007;
                if(j>0) map[i][j] = (map[i][j] + map[i][j-1])%1000000007;
                
            }
        }
        
        return  map[n-1][m-1];
    }
}