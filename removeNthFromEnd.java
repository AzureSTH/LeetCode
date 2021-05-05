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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=new ListNode(); //前面的指针
        ListNode second=new ListNode(); //后面的指针
        first=head;
        second.next=head;
        if(head.next==null) return null;
        for (int i=0;i<n;i++)
            first=first.next;
        while(first!=null) //等于时second指向要删除节点的前一个节点
        {
            first=first.next;
            second=second.next;
        }
        if(second.next==head && head.next!=null) return head.next;
        ListNode p=second.next.next;
        second.next=p;
        return head;
    }
}