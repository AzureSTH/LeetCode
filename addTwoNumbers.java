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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode();
        ListNode p=res;
        int carry=0;
        while(l1!=null&&l2!=null)
        {
            ListNode temp=new ListNode();
            temp.val=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10; //进位
            p.next=temp;
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1==null && l2!=null)
        {
            ListNode temp=new ListNode();
            temp.val=(l2.val+carry)%10;
            carry=(l2.val+carry)/10; //进位
            p.next=temp;
            p=p.next;
            l2=l2.next;
        }
        while(l2==null && l1!=null)
        {
            ListNode temp=new ListNode();
            temp.val=(l1.val+carry)%10;
            carry=(l1.val+carry)/10; //进位
            p.next=temp;
            p=p.next;
            l1=l1.next;
        }
        if (carry>0){
            ListNode temp=new ListNode();
            temp.val=carry;
            p.next=temp;
        }
        return res.next;
    }
}