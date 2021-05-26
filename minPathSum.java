class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], Integer.MAX_VALUE);
        // }
        //填充的一行一列都置0,便于处理边界条件
        dp[0][0]=grid[0][0]; //记录起点数字
        //边界值
        for(int j=1;j<n;j++) //上边界
            dp[0][j]=dp[0][j-1]+grid[0][j];
        for(int i=1;i<m;i++) //左边界
            dp[i][0]=dp[i-1][0]+grid[i][0];
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}