import java.util.*;

public class KnapsackDP {
    public static int knapsack(int[] weights, int[] profits, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] profits = {60, 100, 120};
        int capacity = 50;
        
        int maxProfit = knapsack(weights, profits, capacity);
        System.out.println("Maximum profit in Knapsack: " + maxProfit);
    }
}
