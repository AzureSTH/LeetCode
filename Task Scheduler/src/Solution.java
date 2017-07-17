/*
已知一个字符数组代表CPU需要执行的任务，包含大写字母A-Z代表不同任务。
任务可以不按原始顺序完成，每个任务可以在一个时间间隔里完成。对于每个时间间隔，CPU可以完成一个任务或空闲。
然而，存在一个非负冷却间隔n，它表示在两个相同的任务之间，一定有至少n个间隔是CPU执行不同的任务或空闲。
返回CPU完成所有所给任务所需的最少间隔
*/
import java.io.Console;
import java.util.*;
public class Solution 
{
	public boolean different(int[] tn,int j,int x)
	{
		for(int i = 0;i<x;i++)
		{
			if(tn[i] == j)
				return false;
		}
		return true;
	}
	public int leastInterval(char[] tasks, int n) {
        int intervals = 0;
        int[] tn = new int[n+1];
        int[] a = new int[26];
        int sum = tasks.length;
        int k = -1;//标记最多的字母
        int num = 0;//有几种不同任务
        for(int i = 0;i < tasks.length;i++)
        {
        	a[tasks[i]-'A']++;
        }
        while(sum != 0){
        	num = 0;
        	for(int i = 0;i<n+1;i++)
            	tn[i] = -1;
        	for(int j = 0;j<26;j++)
        	{
        		if(a[j] != 0)
        			num++;
        	}
        	for(int i = 0;i < n+1 && sum > 0;i++)
    		{
        		int max = 0;
        			for(int j = 0;j<26;j++)//求出数量最多的任务
        			{
        				if (a[j] > max && different(tn,j,n+1)) 
        				{
        					max = a[j];
        					k = j;
        					tn[i] = k;//设n个为一组 记录一组内的任务 防止重复
        				}
        			}//for
        			if (num > n && tn[i] >= 0)
        		{
        			if(a[tn[i]] > 0)
        			{
        				intervals++;
        				a[tn[i]]--;
        				sum--;
        			}
        		}
        		else if(num <= n){
        			if(tn[i] >= 0)
        			{
        				intervals++;
        				a[tn[i]]--;
        				sum--;
        			}
        			else intervals++;
        		}
        	}
        }//while
        return intervals;
    }
	public static void main(String[] args){
		Solution t = new Solution();
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int x = s.length();
		char[] tasks = new char[x];
		for (int i = 0; i < s.length(); i++)
		{
			tasks[i] = s.charAt(i);
		}
		int n = in.nextInt();
		int intervals = 0;
		System.out.println(t.leastInterval(tasks, n));
	}
}
