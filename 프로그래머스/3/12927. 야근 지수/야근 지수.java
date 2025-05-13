import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        //야근을 시작한 시점에서 남은일의 작업량을 제곱하여 더한 값
        //N시간동안 야근 피로도 최소화
        //1시간당 작업량 1
        //퇴근까지 N, 각일에대한 작업량 works
        //12345 3
        //1245 1 4 16 25 46
        //12333 1 4 9 9 9 32
        int max = Arrays.stream(works).max().getAsInt();
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num: works){
            queue.offer(num);
        }
        
        for(int i = 0; i < n;i++){
            if(queue.isEmpty())
                return 0;
            
            int num = queue.poll();
            num -= 1;
            if(num > 0)
                queue.offer(num);
        }
        
        
        
        return queue.stream().mapToLong(num -> (long)num * num).sum();
    }
}