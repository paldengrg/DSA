

//Question 2(b)


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WhitelistedRandomPort {
    private int k; // Total number of ports
    private Set<Integer> blacklist; // Set to store blacklisted ports
    private int whitelistSize; // Number of whitelisted ports
    private Random random; // Random number generator

    public WhitelistedRandomPort(int k, int[] blacklisted_ports) {
        this.k = k;
        this.blacklist = new HashSet<>(); // Create a HashSet to store blacklisted ports
        for (int port : blacklisted_ports) {
            blacklist.add(port); // Add blacklisted ports to the HashSet
        }
        this.whitelistSize = k - blacklist.size(); // Calculate the number of whitelisted ports
        this.random = new Random(); // Create a Random object for generating random numbers
    }

    public int get() {
        int randomNum = random.nextInt(whitelistSize); // Generate a random number between 0 and whitelistSize - 1
        int result = -1; // Variable to store the whitelisted random port
        for (int port = 0; port < k; port++) {
            if (!blacklist.contains(port)) {
                if (randomNum == 0) {
                    result = port; // Store the whitelisted random port
                    break; // Exit the loop since we have found the result
                }
                randomNum--; // Decrement randomNum as we haven't found the result yet
            }
        }
        return result; // Return the whitelisted random port
    }

    public static void main(String[] args) {
        int k = 7; // Total number of ports
        int[] blacklisted_ports = {2, 3, 5}; // Array of blacklisted ports
        WhitelistedRandomPort randomPortGenerator = new WhitelistedRandomPort(k, blacklisted_ports);

        System.out.println(randomPortGenerator.get()); // Return a whitelisted random port
        System.out.println(randomPortGenerator.get()); // Return another whitelisted random port
    }
}
