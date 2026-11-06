/**
 * Problem 1: Library Catalog Lookup
 *
 * Approach: Binary search. The catalog is already sorted by ISBN in
 * ascending order, so each probe can discard half of the remaining
 * records instead of scanning linearly.
 *
 * Time complexity:  O(log n) per query
 * Space complexity: O(1) extra space
 *
 * Why appropriate: queries vastly outnumber updates, so the one-off
 * cost of keeping the list sorted is amortized while every lookup
 * stays logarithmic even for very large catalogs.
 */
public class Problem01_LibraryCatalogLookup {

    // catalog[i] = {isbn, title}, sorted by isbn ascending
    public static String findBook(String[][] catalog, String targetIsbn) {
        int lo = 0, hi = catalog.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog[mid][1];
            } else if (cmp < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {
            {"0001112223", "Introduction to Algebra"},
            {"0002223334", "Beginning Python"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Data and Society"},
            {"0005556667", "European History"}
        };
        System.out.println(findBook(catalog, "0003334445")); // "Classic Mythology"
        System.out.println(findBook(catalog, "0009998887")); // "Not Found"
    }
}
