class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int maxsub=0; //最长子串长度
        int index=0;  // 以index为结束下标的最长子串
        String s2=new StringBuffer(s).reverse().toString();
        for (int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                if(s.charAt(i)==s2.charAt(j))
                {
                    if(i==0||j==0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=dp[i-1][j-1]+1;
                }
                if(dp[i][j]>maxsub && n-j-1+dp[i][j]-1==i) //n-j-1是j位置倒置前的下标,倒置前下标加上子串长度得到的子串末下标=i
                {
                    maxsub=dp[i][j];
                    index=i;
                }
            }
        return s.substring(index-maxsub+1,index+1);
    }
}