
//Question 1(b)
//Greedy algorithm
public class MinimumCoins {
    public static int minimumCoins(int[] ratings) {
        int n = ratings.length;
        int[] coins = new int[n]; // Array to store the number of coins assigned to each rider
        coins[0] = 1; // Initialize the number of coins for the first rider to 1

        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                // If the current rider's rating is greater than the previous rider's rating,
                // assign one more coin than the previous rider
                coins[i] = coins[i-1] + 1;
            } else {
                // Otherwise, assign 1 coin to the current rider
                coins[i] = 1;
            }
        }

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && coins[i] <= coins[i+1]) {
                // If the current rider's rating is greater than the next rider's rating
                // and the number of coins for the current rider is less than or equal to the number
                // of coins assigned to the next rider plus one, assign one more coin than the next rider
                coins[i] = coins[i+1] + 1;
            }
        }

        // Calculate the total number of coins required by summing up all the elements in the `coins` array
        int totalCoins = 0;
        for (int i = 0; i < n; i++) {
            totalCoins += coins[i];
        }

        return totalCoins;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int minCoins = minimumCoins(ratings);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}
