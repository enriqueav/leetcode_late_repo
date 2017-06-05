/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 // Took me a while to understand the simplicity of this method
public class Solution {
    
    public void connect(TreeLinkNode root) {
        if( root==null || root.left==null ) return;
        // have at least one level down
        root.left.next = root.right;
        if( root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
