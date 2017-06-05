/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        ListNode root = null;
        ListNode last = null;
        while( t1!=null || t2!=null ){
            int val1 = ( t1 == null ) ? 0 : t1.val;
            int val2 = ( t2 == null ) ? 0 : t2.val;
            
            int res = val1 + val2 + carry;
            
            if( res >= 10 ){
                carry = 1;
                res = res-10;
            } else {
                carry = 0;
            }
            
            if( root == null ){
                root = new ListNode(res);
                last = root;
            } else {
                last.next = new ListNode(res);
                last = last.next;
            }

            if( t1 != null ) t1 = t1.next;
            if( t2 != null ) t2 = t2.next;
        }
        if( carry > 0 ){
            last.next = new ListNode(carry);
            last = last.next;
        }
        return root;
    }
}
