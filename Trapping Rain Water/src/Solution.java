import java.util.*;
public class Solution {
	public int trap(int[] height) {
        int water = 0;
        int i = 0;//循环数
        int max = 0;
        int minmax = 0;
        for(int j = 0;j < height.length;j++)
        {
        	if(height[j] > max)
        		max = height[j];
        }
        while(i<height.length-1)
        {
        	int a = height[i];
        	if(a != 0 && a < max)
        	{
        		int flag = 0;
        		for(int j = i+1;j < height.length;j++)
        		{
        			if(height[j] >= a)
        			{
        				flag = 1;
        				for(int k = i;k < j;k++)
        				{
        					water += a - height[k];
        					height[k] = a;
        				}
        				i = j;
        				break;
        			}
        		}//for j
        		if (flag == 0) max = height[i];
        	}
        	if(a == max)
        	{
        		int x = 0;
        		for(int j = i+1;j < height.length;j++)
                {
                	if(height[j] >= minmax)
                	{
                		minmax = height[j];
                		x = j;
                	}
                }
        		for(int k = i+1;k < x;k++)
				{
					water += minmax - height[k];
					height[k] = minmax;
				}
        		i = x;
        		minmax = 0;
        	}
        	if(a == 0) i++;
        }//while
        return water;
    }
	public static void main(String[] args)
	{
		Solution s = new Solution();
		int n = 0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] height = new int[n];
		System.out.println("输入岩石高度：");
		for(int i = 0;i < n;i++)
			height[i] = in.nextInt();
		System.out.println(s.trap(height));
	}
}