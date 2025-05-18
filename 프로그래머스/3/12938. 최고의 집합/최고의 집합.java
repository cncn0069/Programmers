import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        //각 원소의 합이 S가 되는 수의 집합
        int[] answer = {};
        //18 4
        //4.5
        //5 5 5 3
        //5 5 4 4
        if(n > s){
            int []ttt = {-1};
            return ttt;
        }
        int [] result = new int[n];
        int nanugi = s / n;
        int namurgi = 0;
        if(s%n != 0){
           namurgi = s % n; 
        }
        for(int i = 0; i < n;i++){
            int temp = nanugi;
            if(namurgi > 0){
                temp++;
                namurgi--;
            }
            result[n-i-1] = temp;
        }
        // if(list.size() == 0)
        // {
        //     int []ttt = {-1};
        //     return ttt;
        // }
        return result;
    }
}