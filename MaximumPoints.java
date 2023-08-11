
//Question 3(a)

public class MaximumPoints {
    public static int maxPoints(int[] a) {
        int n = a.length;
        int[] paddedArray = new int[n + 2]; // Array to store the padded version of the input array
        paddedArray[0] = 1; // Padded element at the beginning with a value of 1
        paddedArray[n + 1] = 1; // Padded element at the end with a value of 1
        System.arraycopy(a, 0, paddedArray, 1, n); // Copy the elements from the input array to the padded array

        int[][] dp = new int[n + 2][n + 2]; // Dynamic programming array to store the maximum points

        for (int len = 2; len <= n + 1; len++) {
            for (int start = 0; start <= n + 1 - len; start++) {
                int end = start + len; // Calculate the end index of the subarray
                for (int i = start + 1; i < end; i++) {
                    int points = paddedArray[start] * paddedArray[i] * paddedArray[end]; // Calculate the points gained by shooting the target at index i
                    dp[start][end] = Math.max(dp[start][end], dp[start][i] + points + dp[i][end]); // Update the maximum points at dp[start][end]
                }
            }
        }

        return dp[0][n + 1]; // Return the maximum points that can be gained by hitting each target
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        int maxPoints = maxPoints(a);
        System.out.println("Maximum points: " + maxPoints);
    }
}
