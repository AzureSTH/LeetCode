#include <iostream>
using namespace std;
typedef struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	//TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool BSTInsert(TreeNode * &p, int element)
{
	if (NULL == p) // 空树  
	{
		p = new TreeNode;
		p->val = element;
		p->left = p->right = NULL;
		return true;
	}

	if (element == p->val) // BST中不能有相等的值  
		return false;

	if (element < p->val)  // 递归  
		return BSTInsert(p->left, element);

	return BSTInsert(p->right, element); // 递归  
}

// 建立BST  
void createBST(TreeNode * &T, int a[], int n)
{
	T = NULL;
	int i;
	for (i = 0; i < n; i++)
	{
		BSTInsert(T, a[i]);
	}
}
void mid_order(TreeNode* Node, int k, int &i, int &x)
{
	if (Node != NULL)
	{
		mid_order(Node->left, k, i, x);
		if (k == i)
			x = Node->val;
		i++;
		mid_order(Node->right, k, i, x);
	}
}

int kthSmallest(TreeNode* root, int k) {
	int i = 1;
	int x = 0;
	mid_order(root, k, i, x);
	return x;
}

int main(TreeNode* root, int k) {
	int n = 0;
	cout << "所建树的结点数：";
	cin >> n;
	cout << "输入结点：";
	int b[1000];
	for (int j = 0; j < n; j++)
		cin >> b[j];
	createBST(root, b, n);
	cout << "请输入k值(输入0退出)：";
	cin >> k;
	while (k) {
	cout << kthSmallest(root, k)<<endl;
	cout << "请输入k值(输入0退出)：";
	cin >> k;
	}
	return 0;
}
