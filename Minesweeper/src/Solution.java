import java.util.*;
public class Solution {
	 public char[][] updateBoard(char[][] board, int[] click) {
	        int m = board.length;//行数
	        int n = board[0].length;//列数
	        int x = click[0];
	        int y = click[1];
	        if (board[x][y] == 'M')
	        	board[x][y] = 'X';
	        else
	        { //find mine
	        	int num = 0;
	        	for(int i = -1;i < 2;i++)
	        	{
	        		for(int j = -1;j < 2;j++)
	        		{
	        			if(i == 0 && j == 0) continue;
	        			if(x+i<0 || x+i>=m || y+j<0 || y+j>=n) continue;
	        			if (board[x+i][y+j] == 'M') num++;
	        		}
	        	}
	        	if (num > 0) board[x][y] = (char) (num + '0');
	        	else
	        	{
	        		board[x][y] = 'B';
	        		for(int i = -1;i < 2;i++)
		        	{
		        		for(int j = -1;j < 2;j++)
		        		{
		        			if(i == 0 && j == 0) continue;
		        			if(x+i<0 || x+i>=m || y+j<0 || y+j>=n) continue;
		        			if (board[x+i][y+j] == 'E') 
		        			{
		        				int[] a = {x+i,y+j};
		        				updateBoard(board, a);
		        			}
		        		}
		        	}
	        	}
	        }
	        return board;
	    }
	 public static void main(String[] args)
	 {
		 Solution s = new Solution();
		 char[][] board = new char[5][5];
		 for(int i = 0;i < 5;i++)
     		for(int j = 0;j < 5;j++)
     			board[i][j] = 'E';
		 board[1][2] = 'M';
		 int[] click = {3,0};
		 board = s.updateBoard(board, click);
		 for(int i = 0;i < 5;i++)
	     	for(int j = 0;j < 5;j++)
	     			System.out.print(board[i][j]+" ");
	 }
}
