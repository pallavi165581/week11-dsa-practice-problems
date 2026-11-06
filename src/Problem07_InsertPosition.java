/**
 * Problem 7: Insert Position in a Sorted List
 *
 * Approach: binary search for the "lower bound" — the first index whose
 * value is >= target. If the target exists that index points at it;
 * otherwise it is exactly where the target would be inserted to keep
 * the array sorted.
 *
 * Time complexity:  O(log n)
 * Space complexity: O(1)
 *
 * Why appropriate: the array is sorted and lookups are frequent on very
 * large arrays — binary search keeps each lookup logarithmic, whereas a
 * linear scan would degrade to O(n) per query.
 */
public class Problem07_InsertPosition {

    public static int searchInsertPosition(int[] nums, int target) {
        int lo = 0, hi = nums.length; // hi is exclusive: allows inserting at the end
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 2)); // 1
    }
}
