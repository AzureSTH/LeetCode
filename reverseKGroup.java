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
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode newlist=new ListNode(0); //新表头
        ListNode temp=newlist; //连接新表节点
        ListNode p=head; //遍历旧表
        ListNode log=head; //记录每轮起始节点
        Stack<ListNode> s=new Stack<>();
        while(head!=null)
        {
            int count=k;
            ListNode q;
            while(count!=0 && p!=null)
            {
                count--;
                s.add(p);
                p=p.next;
            }
            if(count>0) //剩余不够k个点
            {
                temp.next=log;
                break;
            }
            else{ //log指向每轮的起始节点
                while(count!=k)
                {
                    log=log.next;
                    count++;
                }
            }
            while(!s.empty()) //接节点
            {
                q=s.peek();
                s.pop();
                temp.next=q;
                temp=temp.next;
            }
        }
        return newlist.next;
    }
}