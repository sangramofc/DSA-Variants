package pattern1_two_pointers.lc1877_minimize_maximum_pair_sum;

/**
 * LeetCode 1877 Variant: Server Cluster Load Balancing
 *
 * Approach: Counting Sort + Bilateral Two-Pointers
 * Time Complexity: O(N + M) where M = max(weights)
 * Space Complexity: O(M) for frequency array
 */
public class Variant1_ServerClusterLoad {

    public static int minMaxClusterLoad(int[] weights, int max_capacity) {
        int maxEL = Integer.MIN_VALUE;
        for (int w : weights) {
            maxEL = Math.max(maxEL, w);
        }

        int[] freq = new int[maxEL + 1];
        for (int w : weights) {
            freq[w]++;
        }

        int maxLoad = 0;
        int l = 0;
        int r = maxEL;

        while (l <= r) {
            if (freq[l] > 0 && freq[r] > 0) {
                int sum = l + r;
                if (sum > max_capacity) {
                    return -1;
                }
                maxLoad = Math.max(maxLoad, sum);

                freq[l]--;
                freq[r]--;
            } else if (freq[l] == 0) {
                l++;
            } else if (freq[r] == 0) {
                r--;
            }
        }

        return maxLoad;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard valid pairing
        int[] weights1 = {3, 5, 2, 6, 4, 4};
        int max_capacity1 = 9;
        System.out.println("Test Case 1 Output: " + minMaxClusterLoad(weights1, max_capacity1)); // Expected: 8

        // Test Case 2: Exceeds capacity ceiling
        int[] weights2 = {8, 12, 10, 15};
        int max_capacity2 = 20;
        System.out.println("Test Case 2 Output: " + minMaxClusterLoad(weights2, max_capacity2)); // Expected: -1

        // Test Case 3: Edge Case - Smallest possible even array (2 elements)
        int[] weights3 = {7, 3};
        int max_capacity3 = 10;
        System.out.println("Test Case 3 Output: " + minMaxClusterLoad(weights3, max_capacity3)); // Expected: 10
    }
}