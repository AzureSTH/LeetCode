class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int low=Integer.MAX_VALUE;
        int res=0;
        for (int i=0;i<n;i++)
        {
            if(prices[i]<low)
                low=prices[i];
            else if(prices[i]-low>res)
                res=prices[i]-low;
        }  
        return res;
            
    }
}