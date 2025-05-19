import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        //단속용 카메라를 한 번은 만나도록 카메라를 설치
        //고속도로를 이동하는 차량의 경로 routes
        //모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇대
        //-20 진입한 지점 -15 고속도로에서 나간 지점
        //-30000이상 30000이하
        //-20 -18 -15 -13  -18 -15
        
        Arrays.sort(routes,(a,b)-> {
                    if(a[1] == b[1]){
                        return a[0] - b[0];
                    }
                    return a[1] - b[1];
            }
        );
        int Camera = 0;
        int position = Integer.MIN_VALUE;
        
        for(int i =  0;i < routes.length;i++){
            int start = routes[i][0];
            int end = routes[i][1];
            
            if(position < start){
                Camera++;
                position = end;
            }
        }
        
        
        return Camera;
    }
}