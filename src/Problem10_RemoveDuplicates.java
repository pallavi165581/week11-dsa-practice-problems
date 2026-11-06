import java.util.Arrays;

/**
 * Problem 10: Remove Duplicates From a Sorted Array In-Place
 *
 * Approach: two pointers. `write` marks where the next unique value
 * belongs; `read` scans forward. Because the array is sorted,
 * duplicates are consecutive, so a value is new exactly when it differs
 * from nums[write - 1].
 *
 * Time complexity:  O(n)
 * Space complexity: O(1) extra — only two indices are used, so it is a
 *                   genuine in-place algorithm (no second array of
 *                   comparable size).
 *
 * Returns the count of unique values; they occupy nums[0..count-1].
 */
public class Problem10_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);                       // length = 5
        System.out.println("nums[0.." + (length - 1) + "] = "
                + Arrays.toString(Arrays.copyOfRange(nums, 0, length))); // [1, 2, 3, 4, 5]
    }
}
