/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public class Solution {
    public TreeNode insert(int[] nums,int initial,int end){
        //if indexes are bad, return null
        if( initial>end  ) return null;
 
        //find mid
        int mid = (end+initial)/2; //e.j. 7/2 = index 3
 
        TreeNode thisNode = new TreeNode(nums[mid]);
        thisNode.left = insert(nums,initial,mid-1);
        thisNode.right = insert(nums,mid+1,end);
        return thisNode;
    }
 
    public TreeNode sortedArrayToBST(int[] nums) {
        if( nums==null || nums.length==0 ) return null;
        return insert(nums,0,nums.length-1);
    }
}
