
//5(a)
public class HillClimbingAlgorithm {

    public static double evaluate(double x) {
        // Example evaluation function, replace with your own
        return -(x * x) + 10; // For finding the maximum of a simple quadratic function
    }

    public static double hillClimbing(double initial, double stepSize, int maxIterations) {
        double currentSolution = initial;
        double currentEvaluation = evaluate(currentSolution);

        for (int i = 0; i < maxIterations; i++) {
            double newSolution = currentSolution + (stepSize * (Math.random() * 2 - 1)); // Random step in range [-stepSize, stepSize]
            double newEvaluation = evaluate(newSolution);

            if (newEvaluation > currentEvaluation) {
                currentSolution = newSolution;
                currentEvaluation = newEvaluation;
            }
        }

        return currentSolution;
    }

    public static void main(String[] args) {
        double initialSolution = 2.0; // Initial guess
        double stepSize = 0.1; // Step size for small adjustments
        int maxIterations = 1000;

        double localMaximum = hillClimbing(initialSolution, stepSize, maxIterations);
        System.out.println("Local maximum found at: " + localMaximum);
        System.out.println("Value at local maximum: " + evaluate(localMaximum));
    }
}
