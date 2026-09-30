package lc1877_minimize_maximum_pair_sum;

public class Original1877 {
        public int minPairSum(int[] nums) {
            int max_el = Integer.MIN_VALUE;
            for (int n : nums) {
                max_el = Math.max(max_el, n);
            }

            int[] freq = new int[max_el + 1];
            for (int n : nums) {
                freq[n]++;
            }

            int max_sum = 0;
            int l = 0;
            int r = max_el;
            while (l <= r) {
                if (freq[l] == 0 && freq[r] == 0) {
                    l++;
                    r--;
                } else if (freq[l] == 0)
                    l++;
                else if (freq[r] == 0)
                    r--;
                else if (freq[l] > 0 && freq[r] > 0) {
                    int sum = l + r;
                    max_sum = Math.max(max_sum, sum);
                    freq[l]--;
                    freq[r]--;
                }
            }

            return max_sum;
        }
}
