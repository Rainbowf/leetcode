package offer2;

import java.util.*;

class Solution051 {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        //后序遍历
        dfs(root, maxSum);

        return maxSum[0];
    }

    private int dfs(TreeNode root, int[] maxSum) {
        if (root == null) return 0;

        int[] maxSumLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.left, maxSumLeft));

        int[] maxSumRight = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.right, maxSumRight));

        maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);
        maxSum[0] = Math.max(maxSum[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }
}