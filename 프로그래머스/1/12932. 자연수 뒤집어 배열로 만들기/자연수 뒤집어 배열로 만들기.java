import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String number = String.valueOf(n);  
        List<Integer> list = new ArrayList<>();
        for(int i = number.length()-1; i >= 0;i--){
            list.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
 
        return list.stream().mapToInt(i->i).toArray();
    }
}