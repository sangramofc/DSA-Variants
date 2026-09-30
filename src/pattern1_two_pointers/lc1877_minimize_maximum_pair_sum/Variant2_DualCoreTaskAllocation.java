package pattern1_two_pointers.lc1877_minimize_maximum_pair_sum;

public class Variant2_DualCoreTaskAllocation {
    /**
     * LeetCode 1877 Variant 2: Dual-Core Processor Task Allocation
     *
     * Pattern: Counting Sort + Bilateral Two Pointers
     * Time Complexity: O(N + M) where M = max(tasks)
     * Space Complexity: O(M) for frequency array
     */
    public static int minMaxThreadTime(int[] tasks, int max_skew) {
        int maxEL = Integer.MIN_VALUE;
        for (int t : tasks) {
            maxEL = Math.max(maxEL, t);
        }

        int[] freq = new int[maxEL + 1];
        for (int t : tasks) {
            freq[t]++;
        }

        int maxTime = 0;
        int l = 0;
        int r = maxEL;

        while (l <= r) {
            if (freq[l] > 0 && freq[r] > 0) {
                int sum = l + r;
                int skew = Math.abs(l - r);
                if (skew > max_skew) {
                    return -1;
                }
                maxTime = Math.max(maxTime, sum);

                freq[l]--;
                freq[r]--;
            } else if (freq[l] == 0) {
                l++;
            } else if (freq[r] == 0) {
                r--;
            }
        }

        return maxTime;
    }

    public static void main(String[] args) {
        // Test Case 1: Valid pairing within max_skew
        int[] tasks1 = {1, 7, 5, 9};
        int max_skew1 = 8;
        System.out.println("Test Case 1 Output: " + minMaxThreadTime(tasks1, max_skew1)); // Expected: 12

        // Test Case 2: Exceeds max_skew limit
        int[] tasks2 = {1, 10, 2, 9};
        int max_skew2 = 5;
        System.out.println("Test Case 2 Output: " + minMaxThreadTime(tasks2, max_skew2)); // Expected: -1

        // Test Case 3: Same values (skew = 0)
        int[] tasks3 = {4, 4, 4, 4};
        int max_skew3 = 0;
        System.out.println("Test Case 3 Output: " + minMaxThreadTime(tasks3, max_skew3)); // Expected: 8
    }
}
