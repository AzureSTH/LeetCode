#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
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

vector<int> rightSideView(TreeNode* root) {
	vector<int> node;
	queue<TreeNode*> que;
	TreeNode *p;
	p = root;
	if (p) que.push(p);
	while (que.size() != 0)
	{
		int s = que.size();
		for (int i = 0; i < s; i++)
		{
			p = que.front();
			que.pop();
			if (i == 0) node.push_back(p->val);
			if (p->right != NULL) que.push(p->right);
			if (p->left != NULL) que.push(p->left);
		}
	}
	return node;
}
int main()
{
	TreeNode* root;
	int n = 0;
	cout << "�������Ľ������";
	cin >> n;
	cout << "�����㣺";
	int b[1000];
	for (int j = 0; j < n; j++)
		cin >> b[j];
	createBST(root, b, n);
	int num = rightSideView(root).size();
	vector<int> node = rightSideView(root);
	for (int i = 0; i < num; i++)
		cout << node[i] << " ";
	system("pause");
	return 0;
}