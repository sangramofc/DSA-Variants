package pattern1_two_pointers.lc0283_move_zeroes;

import java.util.Arrays;

/**
 * LeetCode 283 Variant 2: Dual-Boundary Task Partitioning (Auxiliary Array Solution)
 *
 * Approach: Sequential copying using an extra array
 * Time Complexity: O(N)
 * Space Complexity: O(N) extra space
 */
public class Variant2_DualBoundaryPartitioning_ExtraSpace {

    public static int[] partitionTasks(int[] tasks) {
        if (tasks == null) return new int[0];

        int[] ans = new int[tasks.length];
        int write = 0;

        // Pass 1: Copy all negative tasks (preserves relative order)
        for (int task : tasks) {
            if (task < 0) {
                ans[write++] = task;
            }
        }

        // Pass 2: Copy all positive tasks (preserves relative order)
        for (int task : tasks) {
            if (task > 0) {
                ans[write++] = task;
            }
        }

        // Unfilled trailing indices in ans are automatically 0 in Java
        return ans;
    }

    public static void main(String[] args) {
        int[] t1 = {3, -1, 0, 2, -4, 0, 1};
        System.out.println("Result: " + Arrays.toString(partitionTasks(t1)));
        // Output: [-1, -4, 3, 2, 1, 0, 0]
    }
}