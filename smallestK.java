import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res= new ArrayList<>();
        int length=input.length;
        if(length<k||k==0) return res;
        Queue<Integer> q=new PriorityQueue<>(k,(a,b)->(b-a)); //lambda表达式实现比较器
        for(int i=0;i<length;i++)
        {
            if (q.size()<k) q.add(input[i]);
            else{
                if(input[i]<q.peek()){
                    q.poll();
                    q.add(input[i]);
                }
            }//else
        }
        res.addAll(q);
        return res;
    }
}