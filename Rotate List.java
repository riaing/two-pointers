Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

1. k<=0 || head == NULL，直接返回。
2. k>= L，L为list总长。对于例子中的list，当k=5时旋转后又回到原来状态。所以实际旋转的次数为k%L。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
   
        ListNode slow = head; 
        ListNode quick = head;
        int length = 1;
      
      //一， 算出initial的quick在哪。
        //1， k< length，这里如果K < length, 就没必要求出全length了
        for ( int i = 0; i < k; i++){ 
            if(quick.next == null){ //这里用来判断是否 k>= length, 是的话跳出loop，进入 2.
                quick = head; 
                break;
            }
            else { //这里是k<length的情况。
                length ++; 
                quick = quick.next;
            } 
        }
        
        //2， k >= length 
        if(k >= length){
        int loop = k% length;
        if(loop == 0){ //like [1]. k==list.length
            return head; 
        }
        else{
            for(int j = 0; j< loop; j ++){
                quick = quick.next;
            }
        }
        }
        //二， 结束计算 initial quick的位置，接下来移动slow 和quick。 
        while(quick != null & quick.next != null){  //还是要扫到列表最后所以O（N）
            quick = quick.next;
            slow = slow.next; 
        }
        //三，变换头结点
        quick.next = head; 
        head = slow.next; 
        slow.next = null; 
        return head; 
        
    }
}
