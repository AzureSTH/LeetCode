import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxsub=0;
        if (s=="") return maxsub;
        int left=0; //子串的起始位置
        int pos=0; //向前移动
        int[] used=new int[256];
        for (int i=0;i<used.length;i++)
            used[i]=-1;
        while(pos<s.length())
        {
            while (used[s.charAt(pos)]!=-1){
                used[s.charAt(left)]=-1;
                left++;
            }
            maxsub=Math.max(maxsub,pos-left+1);
            used[s.charAt(pos)]=pos;
            pos++;
        }
        return maxsub;
    }
}