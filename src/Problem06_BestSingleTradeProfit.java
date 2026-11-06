/**
 * Problem 6: Best Single Trade Profit
 *
 * Approach: single pass. Track the lowest price seen so far (best day
 * to buy). At each day, the best sale ending that day is
 * price - minSoFar; keep the maximum of those.
 *
 *   Single-pass: Time O(n), Space O(1)
 *   Check-every-pair (brute force): Time O(n^2), Space O(1)
 *
 * Why preferable at scale: O(n^2) means a year of daily prices (~365)
 * needs ~66k comparisons and a decade of minute-level data becomes
 * infeasible; the O(n) scan does one comparison per element and grows
 * linearly with history length.
 */
public class Problem06_BestSingleTradeProfit {

    public static int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int best = 0;
        for (int p : prices) {
            if (p < minSoFar) {
                minSoFar = p;
            } else {
                best = Math.max(best, p - minSoFar);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5 (buy 1, sell 6)
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
    }
}
