/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minD(int depth,TreeNode root){
        if( root==null ) return Integer.MAX_VALUE;
        if( root.left==null && root.right==null ) return depth;
        return Math.min(minD(depth+1,root.left),minD(depth+1,root.right));
    }
    public int minDepth(TreeNode root) {
        if( root == null ) return 0;
        return minD(1,root);
    }
}
