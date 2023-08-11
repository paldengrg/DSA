
//Question 2(a)
//Dynamic Programming

import java.util.Arrays;
public class LongestSubsequence {
    public static int longestSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n]; // Array to store the length of the longest subsequence ending at each index
        Arrays.fill(dp, 1); // Initialize all elements of dp to 1 since the minimum length of a subsequence is 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j] && nums[j] - nums[i] <= k) {
                    // If the current element is smaller than the previous element
                    // and the difference between them is at most k, update dp[i] to be the maximum
                    // of its current value and dp[j] + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            // Find the maximum value in dp, which represents the length of the longest subsequence
            // that ends at each index
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength; // Return the maximum length of the subsequence that meets the requirements
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
        int k = 3;
        int length = longestSubsequence(nums, k);
        System.out.println("Length of the longest subsequence: " + length);
    }
}

