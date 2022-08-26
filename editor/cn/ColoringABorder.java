/**
  * 题目Id：1034
  * 题目：边界着色
  * 日期：2022-08-07 17:54:45
*/
//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 两个网格块属于同一 连通分量 需满足下述全部条件： 
//
// 
// 两个网格块颜色相同 
// 在上、下、左、右任意一个方向上相邻 
// 
//
// 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块： 
//
// 
// 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻 
// 在网格的边界上（第一行/列或最后一行/列） 
// 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics深度优先搜索 | 广度优先搜索 | 数组 | 矩阵 
//
// 👍 150, 👎 0 
//
//
//
//

package leetcode.editor.cn;
public class ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new ColoringABorder().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int m, n;
        private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int oldColor = grid[row][col];
            m = grid.length; n = grid[row].length;
            dfs(grid, row, col, oldColor, color);
            return grid;
        }

        private void dfs(int[][] grid, int i, int j, int oldColor, int newColor) {
            for (int[] dir: dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                if(r>=0 && r < m&& c >= 0 && c < n && grid[r][c] == oldColor) {

                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 