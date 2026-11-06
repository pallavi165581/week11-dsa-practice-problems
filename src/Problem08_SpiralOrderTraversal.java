import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 8: Spiral Order Traversal
 *
 * Approach: four boundary pointers (top, bottom, left, right). Walk the
 * top row left->right, right column top->bottom, bottom row
 * right->left, left column bottom->top, then shrink the boundaries and
 * repeat. Checks between directions avoid re-walking rows/columns on
 * non-square grids.
 *
 * Time complexity:  O(m * n) — each cell is visited exactly once.
 * Space complexity: O(m * n) for the output list (O(1) extra space
 *                   excluding the output).
 */
public class Problem08_SpiralOrderTraversal {

    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> out = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return out;
        }
        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                out.add(grid[top][c]);
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                out.add(grid[r][right]);
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    out.add(grid[bottom][c]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    out.add(grid[r][left]);
                }
                left++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(spiralOrder(grid)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
