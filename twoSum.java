import java.util.*;


public class Solution {
    /**
     * 
     * @param numbers int整型一维数组 
     * @param target int整型 
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res=new int[2];
        for (int i=0;i<numbers.length;i++)
            map.put(numbers[i],i+1);
        for (int i=0;i<numbers.length;i++)
        {
            if(map.containsKey(target-numbers[i]) && (i+1)!=map.get(target-numbers[i]))
            {
                res[0]=i+1; //此处注意
                res[1]=map.get(target-numbers[i]);
                break;
            }
        }
        return res;
    }
}