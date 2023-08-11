
//Question 1(a)
//Dynamic Programming approach


public class MinimumCost {
    public static int findMinimumCost(int N, int[][] price) {
        int[][] dp = new int[N][3]; // Create a 2D array to store minimum costs for each person and color

        // Base cases
        dp[0][0] = price[0][0]; // Minimum cost for person 0 choosing color 0
        dp[0][1] = price[0][1]; // Minimum cost for person 0 choosing color 1
        dp[0][2] = price[0][2]; // Minimum cost for person 0 choosing color 2

        for (int i = 1; i < N; i++) {
            // Calculate minimum cost for each color choice for person i
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0]; // Minimum cost for person i choosing color 0
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1]; // Minimum cost for person i choosing color 1
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2]; // Minimum cost for person i choosing color 2
        }

        // Find the minimum cost among the last row
        int minCost = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])); // Minimum cost for the last person
        return minCost;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] price = {{14, 4, 11}, {11, 14, 3}, {14, 2, 10}};
        int minimumCost = findMinimumCost(N, price);
        System.out.println("Minimum cost: " + minimumCost);
    }
}
