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
    public int sum(TreeNode root,String soFar){
        if( root == null ) return Integer.parseInt(soFar);
        if( root.left == null && root.right == null ) return Integer.parseInt(soFar+root.val);
        int retVal = 0;
        if( root.left  != null) retVal += sum(root.left,soFar+root.val+"");
        if( root.right != null) retVal += sum(root.right,soFar+root.val+"");
        return retVal;
    }
    public int sumNumbers(TreeNode root) {
        return sum(root,"0");
    }
}
