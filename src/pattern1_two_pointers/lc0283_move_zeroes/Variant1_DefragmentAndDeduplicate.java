package pattern1_two_pointers.lc0283_move_zeroes;

/**
 * LeetCode 283 Variant 1: In-Place Data Defragmentation & De-duplication
 *
 * Problem Context:
 * Given an integer array 'nums' containing invalid/corrupted marker values (-1)
 * alongside valid positive integers, modify the array in-place to move all -1
 * markers to the end while removing adjacent duplicates among valid integers.
 * The relative order of valid, unique integers must be preserved.
 *
 * Approach: Same-Direction Two Pointers (Read & Write Pointers) / (Fast & Slow Pointers)
 * Time Complexity: O(N) where N is the length of the array
 * Space Complexity: O(1) auxiliary space
 */
public class Variant1_DefragmentAndDeduplicate {

    public static int defragment(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int write = 0; // Slow pointer: position for the next valid element

        // Read pointer (Fast pointer): scans every element
        for (int read = 0; read < nums.length; read++) {
            // Skip invalid markers
            if (nums[read] == -1) {
                continue;
            }

            // Skip adjacent duplicates (compare against last written valid element)
            if (write > 0 && nums[read] == nums[write - 1]) {
                continue;
            }

            // Write valid element and advance write pointer
            nums[write++] = nums[read];
        }

        int validCount = write;

        // Fill trailing array positions with -1 tombstone markers
        while (write < nums.length) {
            nums[write++] = -1;
        }

        return validCount;
    }

    public static void main(String[] args) {
        // Test Case 1: Interspersed invalid markers and duplicates
        int[] t1 = {1, 1, -1, 2, 2, -1, 3, 1};
        int count1 = defragment(t1);
        System.out.println("Test 1 Valid Count: " + count1);
        // Expected: 4
        System.out.println("Test 1 Array: " + java.util.Arrays.toString(t1));
        // Expected: [1, 2, 3, 1, -1, -1, -1, -1]

        // Test Case 2: Duplicate separated by an invalid marker
        int[] t2 = {1, -1, 1};
        int count2 = defragment(t2);
        System.out.println("Test 2 Valid Count: " + count2);
        // Expected: 1
        System.out.println("Test 2 Array: " + java.util.Arrays.toString(t2));
        // Expected: [1, -1, -1]
    }
}