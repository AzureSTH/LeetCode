import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        if (root==null) return res;
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            ArrayList<Integer> node=new ArrayList<>();
            for (int i=0;i<n;i++)
            {
                TreeNode first=q.poll();
                node.add(first.val);
                if (first.left!=null) q.add(first.left);
                if (first.right!=null) q.add(first.right);
            }
            res.add(node);
        }
        return res;
    }
}