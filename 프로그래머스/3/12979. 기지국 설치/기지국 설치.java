import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
      
        //아파트의 개수 n
        //혀내 기지국이 설치된 아파트 번호
        //전파 도달 거리 w
        
        //1 2 0 0 0 5 6 7 8 9 0 0
        int end = 0;
        int index = 0;
        while(index < stations.length){
            
            int middle = stations[index++];
            
            if(end < middle - w){
                int need = middle - w - 1 - end;
                answer += need/(2*w+1);
                answer += need%(2*w+1) == 0 ? 0 : 1;
                end = middle + w;
                
                continue;
            } 
            end = middle + w;
        }
        if(end < n){
            answer += (n-end)/(2*w+1);
            answer += (n-end)%(2*w+1) == 0 ? 0 : 1;
        }
        
        
        return answer;
    }
}