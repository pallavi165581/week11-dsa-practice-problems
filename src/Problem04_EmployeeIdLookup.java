import java.util.HashMap;
import java.util.Map;

/**
 * Problem 4: Employee ID Lookup in an Unsorted Directory
 *
 * Approach: buildLookup() converts the unordered list into a HashMap
 * keyed by employeeId once (O(n) build time, O(n) space). Every
 * subsequent getDepartment() call is then O(1) average instead of an
 * O(n) linear scan of the raw list.
 *
 * Why appropriate: the directory is queried dozens of times a day but
 * updated only a few times a month. Paying O(n) once (plus O(n) space)
 * to make every query O(1) wins as soon as more than a handful of
 * lookups happen — exactly the "queries vastly outnumber updates"
 * scenario.
 *
 * getDepartment time:  O(1) average
 * Lookup space cost:   O(n)
 */
public class Problem04_EmployeeIdLookup {

    // records[i] = {employeeId, department}
    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] rec : records) {
            lookup.put(rec[0], rec[1]);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };
        Map<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390")); // "Marketing"
        System.out.println(getDepartment(lookup, "E999")); // "Unknown"
    }
}
