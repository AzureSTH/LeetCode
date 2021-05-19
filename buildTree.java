import java.util.Stack;

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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		TreeNode root = new TreeNode(preorder[0]);// 根节点入栈
		Stack<TreeNode> tree = new Stack<>();
		tree.push(root);
		int index = 0; // 指向中序遍历
		for (int i = 1; i < preorder.length; i++) {
			TreeNode node = tree.peek(); // 存栈顶节点
			TreeNode child = new TreeNode(); // 保存子节点
			if (node.val != inorder[index]) {
				node.left = new TreeNode(preorder[i]);
				tree.push(node.left);
			} else {
				while (!tree.isEmpty() && tree.peek().val == inorder[index]) {
					node = tree.pop();
					index++;
				}
				node.right = new TreeNode(preorder[i]);
				tree.push(node.right);
			}

		}
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		Solution s = new Solution();
		s.buildTree(preorder, inorder);
	}
}