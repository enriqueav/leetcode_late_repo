# https://leetcode.com/problems/range-sum-of-bst
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def findSuma(self, root, mini, maxi):
        if not root:
            return 0
        suma = 0
        if root.val >= mini and root.val <= maxi:
            suma = root.val
        
        if maxi > root.val:
            suma += self.findSuma(root.right, mini, maxi)
        if mini < root.val:
            suma += self.findSuma(root.left, mini, maxi)
        return suma
        
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        return self.findSuma(root, L, R)


# RESULT
# Runtime: 240 ms, faster than 60.83% of Python3 online submissions for Range Sum of BST.
# Memory Usage: 21.7 MB, less than 5.06% of Python3 online submissions for Range Sum of BST.