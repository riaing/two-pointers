Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.


链表头是X，环的第一个节点是Y，slow和fast第一次的交点是Z。各段的长度分别是a,b,c，如图所示。环的长度是L。
第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。

因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+(L)*n+b，可以得到a=nL-b*（这个结论很重要！）。

如果圈很小，而a很长，那么b的长度就会是绕圈几周了，但是结果也是一样成立的。

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

    //cosider coner case [1,2](two nodes), fast == slow is at 2, when enter 2nd while, since
    //fast, slow always differ 1, will have endless loop. 
    //here put slow and fast both at head, just one more iteration, but could put fast == slow at 1. 
    
    ListNode slow = head;
    ListNode fast = head;

    do { 
        if (fast == null || fast.next == null) {
            return null;    //遇到null了，说明不存在环
        }
        slow = slow.next;
        fast = fast.next.next;
    }while(fast != slow);
          //第一次相遇在Z点

    slow = head;    //slow从头开始走，
    while (slow != fast) {    //二者相遇在Y点，则退出
        slow = slow.next;
        fast = fast.next;
    }
    return slow;

        
    }
}
