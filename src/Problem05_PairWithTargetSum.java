import java.util.HashSet;
import java.util.Set;

/**
 * Problem 5: Pair With Target Sum (Unsorted)
 *
 * Approach implemented: HashSet of seen values. For each n we check
 * whether (target - n) was already seen — one pass, no sorting needed.
 *
 *   Time: O(n)   Space: O(n)
 *
 * Other approaches and trade-offs:
 *   1. Brute force — check every pair with nested loops.
 *        Time: O(n^2)  Space: O(1). No extra memory but too slow at scale.
 *   2. Sort + two pointers — sort a copy, then scan inward from both ends.
 *        Time: O(n log n)  Space: O(n) for the copy (O(1) extra if the
 *        input may be mutated). Slower than hashing but uses less memory
 *        and preserves indices only if tracked separately.
 *   3. HashSet (chosen) — fastest at O(n) time; costs O(n) extra space,
 *        which is the right trade when runtime matters most.
 */
public class Problem05_PairWithTargetSum {

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(target - n)) {
                return true;
            }
            seen.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));  // true  (2 + 7 = 9)
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));      // false
    }
}
