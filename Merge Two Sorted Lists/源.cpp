#include <iostream>
using namespace std;
 struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };

 ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
     ListNode* merge, * pend, * m; //m是指向需要下下来的节点
     merge = new ListNode;
     pend = merge;
     if (l1 == NULL) return l2;
     if (l2 == NULL) return l1;
     while (l1->next != NULL && l2->next != NULL)
     {
         if (l1->next->val <= l2->next->val)
         {
             m = l1->next;
             l1->next = m->next;
             pend->next = m;
         }
         else {
             m = l2->next;
             l2->next = m->next;
             pend->next = m;
         }
         pend = pend->next;
         pend->next = NULL;
     }
     if (l1 != NULL)
         pend->next = l1->next;
     if (l2 != NULL)
         pend->next = l2->next;
     return merge;
 }
int main() {
    ListNode * l1,* l2, * p1, * q1, * p2, * q2; //p是不断创建的新节点
    int num;
    l1 = new ListNode;
    l2 = new ListNode;
    q1 = l1; //q1会不断移动，始终指向当前的尾节点
    q2 = l2;
    int count = 1;
    while (cin >> num)
    {
        p1 = new ListNode;
        p1->val = num;
        q1->next = p1;
        q1 = p1;
        if (cin.get() == '\n')
            break;
        count++;
    }
    q1->next = nullptr;
    l1->val = count;
    count = 1;
    while (cin >> num)
    {
        p2 = new ListNode;
        p2->val = num;
        q2->next = p2;
        q2 = p2;
        if (cin.get() == '\n')
            break;
        count++;
    }
    q2->next = nullptr;
    l2->val = count;
    cout << mergeTwoLists(l1, l2) << endl;
    return 0;
}