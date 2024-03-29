import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param l1 ListNode类 
     * @param l2 ListNode类 
     * @return ListNode类
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head;
        if(l2.val>=l1.val) {
            head=l1;
            l1=l1.next;
        }
        else {
            head=l2;
            l2=l2.next;
             }
        ListNode p=head;
        while(l1!=null&&l2!=null)
        {
            
            if (l2.val>=l1.val)
            {
                p.next=l1;
                l1=l1.next;
            }
            else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1==null) p.next=l2;
        else p.next=l1;
        return head;
    }
}