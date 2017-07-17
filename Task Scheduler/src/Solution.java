/*
��֪һ���ַ��������CPU��Ҫִ�е����񣬰�����д��ĸA-Z����ͬ����
������Բ���ԭʼ˳����ɣ�ÿ�����������һ��ʱ��������ɡ�����ÿ��ʱ������CPU�������һ���������С�
Ȼ��������һ���Ǹ���ȴ���n������ʾ��������ͬ������֮�䣬һ��������n�������CPUִ�в�ͬ���������С�
����CPU�����������������������ټ��
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
        int k = -1;//���������ĸ
        int num = 0;//�м��ֲ�ͬ����
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
        			for(int j = 0;j<26;j++)//���������������
        			{
        				if (a[j] > max && different(tn,j,n+1)) 
        				{
        					max = a[j];
        					k = j;
        					tn[i] = k;//��n��Ϊһ�� ��¼һ���ڵ����� ��ֹ�ظ�
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
