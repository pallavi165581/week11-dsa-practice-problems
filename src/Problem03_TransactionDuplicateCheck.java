import java.util.HashSet;
import java.util.Set;

/**
 * Problem 3: Transaction Duplicate Check
 *
 * Approach: HashSet. Insert each ID; HashSet.add() returns false when
 * the element already exists, so the first failed add means a duplicate.
 *
 * Time complexity:  O(n) average — O(1) per insert/lookup.
 * Space complexity: O(n) for the set.
 *
 * Lower-memory alternative: sort a copy of the list (O(n log n) time,
 * O(n) space for the copy — or O(1) extra if sorting in place) and then
 * compare adjacent elements; or use nested loops (O(n^2) time, O(1)
 * space). Both trade runtime for memory. Since the batch has millions
 * of IDs and the check is time-sensitive, spending O(n) memory to get
 * O(n) runtime is the right trade-off.
 */
public class Problem03_TransactionDuplicateCheck {

    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(
                new String[]{"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"})); // true
        System.out.println(hasDuplicate(
                new String[]{"TXN2001", "TXN2002", "TXN2003"}));                        // false
    }
}
