package offer2;

import java.util.Arrays;

class Solution099 {
    //动态规划 ，二维数组扩充一列
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m + 1][n + 1];
//        Arrays.fill(dp[0], Integer.MAX_VALUE);
//        for (int i = 1; i < m + 1; i++) {
//            dp[i][0] = Integer.MAX_VALUE;
//        }
//        dp[0][1] = 0;
//        for (int i = 1; i < m + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
//            }
//        }
//        return dp[m][n];
//    }

    //动态规划 ，用原数组不扩充
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //第0列填充
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        //第0行填充
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        //剩余填充
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    //动态规划，时间mn，空间n，用一行数组储存
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        dp[0] = grid[0][0];
        //第0行填充
        for (int j = 1; j < n; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }
        //其余行
        for (int i = 1; i < m; i++) {
            //第0列填充
            dp[0] += grid[i][0];////行首单独处理，只能选择前一行的值
            for (int j = 1; j < n; j++) {
                //选择上一行 和 左侧 的 值
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}