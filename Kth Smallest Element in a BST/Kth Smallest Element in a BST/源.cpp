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
	if (NULL == p) // ����  
	{
		p = new TreeNode;
		p->val = element;
		p->left = p->right = NULL;
		return true;
	}

	if (element == p->val) // BST�в�������ȵ�ֵ  
		return false;

	if (element < p->val)  // �ݹ�  
		return BSTInsert(p->left, element);

	return BSTInsert(p->right, element); // �ݹ�  
}

// ����BST  
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
	cout << "�������Ľ������";
	cin >> n;
	cout << "�����㣺";
	int b[1000];
	for (int j = 0; j < n; j++)
		cin >> b[j];
	createBST(root, b, n);
	cout << "������kֵ(����0�˳�)��";
	cin >> k;
	while (k) {
	cout << kthSmallest(root, k)<<endl;
	cout << "������kֵ(����0�˳�)��";
	cin >> k;
	}
	return 0;
}
