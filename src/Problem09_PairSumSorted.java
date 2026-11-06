import java.util.Arrays;

/**
 * Problem 9: Pair Sum in a Sorted Array
 *
 * Approach: two pointers — left at the smallest value, right at the
 * largest. If the sum is too small move left rightward; too large move
 * right leftward; equal means we found the pair. Works even with
 * negatives because the array order is what matters.
 *
 * Time complexity:  O(n)   Space complexity: O(1)
 *
 * Compared to ignoring the sorted property: a brute-force pair check is
 * O(n^2) time, and a hash-set scan is O(n) time but O(n) space. The
 * two-pointer method gets O(n) time with O(1) space precisely because
 * the sorted order tells us which pointer to move.
 *
 * Returns int[]{a, b} or null when no pair exists.
 */
public class Problem09_PairSumSorted {

    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] pair = pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4);
        System.out.println(pair != null ? "(" + pair[0] + ", " + pair[1] + ")" : "Not Found");
        // (-1, 5)

        pair = pairSumSorted(new int[]{1, 2, 3}, 100);
        System.out.println(pair != null ? "(" + pair[0] + ", " + pair[1] + ")" : "Not Found");
        // Not Found
    }
}
