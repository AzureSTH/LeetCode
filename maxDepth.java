/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        //BFS
        if (root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        int res=0;
        q.add(root);
        while(!q.isEmpty())
        {
            res++;
            int n=q.size();
            for (int i=0;i<n;i++)
            {
                TreeNode temp=q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
        return res;
    }
}