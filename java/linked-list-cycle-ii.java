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
        if( head==null || head.next==null || head.next.next==null ) return null;
        if( head.next == head ) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast!=slow && fast.next!=null && fast.next.next!=null );
        
        if(fast==null||fast.next==null||fast.next.next==null) 
            return null;
        else {
            slow = head; 
        }
        
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
