/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if( head == null || (head.next==null&&head.val==val) ) return null;
        
        // set new head if needed: if head values are equal to vla
        while(head!=null && head.val == val){
           head = head.next; 
        } 
        
        ListNode tmp = head;
        while( tmp!=null ){
            while(tmp.next!=null && tmp.next.val == val){
              tmp.next=tmp.next.next;  
            } 
            tmp = tmp.next;
        }
        return head;
    }
}
