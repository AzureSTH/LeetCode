import java.util.*;

public class Solution {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int maxsum=arr[0]; //记录最大和
        int pre=arr[0]; //当前位置前的累加和
        for (int i=1;i<arr.length;i++)
        {
            pre=Math.max(arr[i],arr[i]+pre);
            maxsum=Math.max(maxsum,pre);
        }
        return maxsum;
    }
}