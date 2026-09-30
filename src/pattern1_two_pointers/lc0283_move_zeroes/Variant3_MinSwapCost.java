package pattern1_two_pointers.lc0283_move_zeroes;

/**
 * LeetCode 283 Variant 3: Minimal Swap Count with Adjacent Distance Overhead
 *
 * Approach: Mathematical Displacement Tracking (Single Pass)
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space
 */
public class Variant3_MinSwapCost {

    public static long minSwapCost(int[] server_status) {

        int count0s = 0;
        long cost= 0L;
        for (int i = 0; i < server_status.length; i++) {
            if (server_status[i] == 0) count0s++;
            else cost += count0s;
        }
        return cost;
    }
    public static void main(String[] args) {
        // Test Case 1: Interleaved servers [0, 1, 0, 1, 1] -> Expected: 5
        int[] t1 = {0, 1, 0, 1, 1};
        System.out.println("Test 1 Cost: " + minSwapCost(t1) + " (Expected: 5)");

        // Test Case 2: Already consolidated [1, 1, 0, 0] -> Expected: 0
        int[] t2 = {1, 1, 0, 0};
        System.out.println("Test 2 Cost: " + minSwapCost(t2) + " (Expected: 0)");

        // Test Case 3: All offline servers at start [0, 0, 1] -> Expected: 2
        int[] t3 = {0, 0, 1};
        System.out.println("Test 3 Cost: " + minSwapCost(t3) + " (Expected: 2)");

        // Test Case 4: Alternating [0, 1, 0, 1] -> Expected: 3
        int[] t4 = {0, 1, 0, 1};
        System.out.println("Test 4 Cost: " + minSwapCost(t4) + " (Expected: 3)");
    }
}