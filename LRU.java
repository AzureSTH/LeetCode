import java.util.*;


public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        ArrayList<Integer> list=new ArrayList();
        Queue<int[]> queue = new LinkedList<int[]>();
        Map<Integer,int[]> map=new HashMap();
        for (int i=0;i<operators.length;i++)
        {
            if(k<queue.size())
            {
                int[] poll=queue.poll();
                map.remove(poll[1]); //移除map里的键值
            }
            if (operators[i][0]==1)
            {
                map.put(operators[i][1],operators[i]);
                queue.offer(operators[i]);
            }
            else 
            {
                int[] temp=map.get(operators[i][1]);
                if (temp!=null)
                {
                    queue.remove(temp);
                    queue.offer(temp);
                    list.add(temp[2]);
                }
                else list.add(-1);
            }
        }//for
        int[] res=new int[list.size()];
            for (int j=0;j<list.size();j++)
                res[j]=list.get(j);
        return res;
    }
}