/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummynode=new ListNode(-1); //虚拟头节点
        dummynode.next=head;
        ListNode pre=dummynode;
        for (int i=0;i<left-1;i++)
            pre=pre.next; //将指针移到需要反转的前一个位置
        ListNode cur=pre.next;
        for (int j=0;j<right-left;j++)
        {
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummynode.next;
    }
}