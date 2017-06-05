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
    public boolean hasCycle(ListNode head) {
        if( head==null || head.next==null || head.next.next==null ) return false;
        if( head.next == head ) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast!=slow && fast.next!=null && fast.next.next!=null );
        
        if(fast==null||fast.next==null||fast.next.next==null) 
            return false;
        else {
            return true;
        }
    }
}
