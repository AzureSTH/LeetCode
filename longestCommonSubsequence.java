class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        text1=" "+text1;
        text2=" "+text2;
        int[][] dp=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
            dp[i][0]=1;
        for(int j=0;j<=len2;j++)
            dp[0][j]=1;
        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++)
            {
                if(text1.charAt(i)==text2.charAt(j))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        return dp[len1][len2]-1;
    }
}