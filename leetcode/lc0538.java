package leetcode;

import java.util.*;

//offer2q054

class Solution0538 {
    //递归写法
    private int newSum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.right);
            newSum += root.val;
            root.val = newSum;
            dfs(root.left);
        }
    }

        public TreeNode convertBST2(TreeNode root) {
        //中序遍历-入栈法
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }
}