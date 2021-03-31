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
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    public int[][] threeOrders (TreeNode root) {
        // write code here
        preorder(root);
        inorder(root);
        postorder(root);
        int[][] res={pre.stream().mapToInt(Integer::valueOf).toArray(),in.stream().mapToInt(Integer::valueOf).toArray(),post.stream().mapToInt(Integer::valueOf).toArray()};
        return res;
    }
    public void preorder(TreeNode root)
    {
        if (root==null) return;
        pre.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(TreeNode root)
    {
        if (root==null) return;
        inorder(root.left);
        in.add(root.val);
        inorder(root.right);
    }
    public void postorder(TreeNode root)
    {
        if (root==null) return;
        postorder(root.left);
        postorder(root.right);
        post.add(root.val);
    }
}