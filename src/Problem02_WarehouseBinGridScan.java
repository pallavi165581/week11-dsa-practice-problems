/**
 * Problem 2: Warehouse Bin Grid Scan
 *
 * Approach: single pass over the grid keeping a running total and the
 * maximum value seen so far with its coordinates. A strict '>'
 * comparison keeps the FIRST maximum when ties occur (row-by-row,
 * left-to-right order).
 *
 * Time complexity:  O(m * n) — every cell must be inspected once.
 * Space complexity: O(1) extra space beyond the input grid.
 *
 * Returns int[] {total, maxRow, maxCol}.
 */
public class Problem02_WarehouseBinGridScan {

    public static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1, maxRow = -1, maxCol = -1;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        int[] result = warehouseSummary(grid);
        System.out.println("total = " + result[0]
                + ", maxCoordinate = (" + result[1] + ", " + result[2] + ")");
        // total = 49, maxCoordinate = (2, 1)
    }
}
