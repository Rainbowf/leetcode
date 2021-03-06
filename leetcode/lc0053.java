package leetcode;

import java.util.*;

class Solution0053 {
    //dp序列常规思路
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // 定义：dp[i] 记录以 nums[i] 为结尾的「最大子数组和」
        int[] dp = new int[len];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];

        int res = nums[0];
        // 状态转移方程
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
    //dp滚动变量优化
    public int maxSubArray2(int[] nums) {
        int len = nums.length;

        int dp = nums[0];
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            dp = Math.max(nums[i], nums[i] + dp);
            res = Math.max(dp, res);
        }
        return res;
    }

    //前缀和
    public int maxSubArray3(int[] nums) {
        int ans = Integer.MIN_VALUE, sum = 0, min = 0;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum - min);
            min = Math.min(sum, min);
        }
        return ans;
    }
}