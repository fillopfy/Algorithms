import java.util.*;

public class Knapsack01 {
    private static int[][] memo;

    public static void main(String[] args) {
        int[] wt = new int[] { 1, 3, 4, 5 };
        int[] val = new int[] { 1, 4, 5, 7 };
        int W = 8;
        memo = new int[wt.length + 1][W + 1];
        for (int i = 0; i <= wt.length; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(knapsackDP(wt, val, W, wt.length));

        System.out.println(knapsackRecursive(wt, val, W, wt.length));
        System.out.println(knapsackMemoized(wt, val, W, wt.length));
    }

    // recursive solution for 0/1 knapsack

    private static int knapsackRecursive(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsackRecursive(wt, val, W - wt[n - 1], n - 1),
                    knapsackRecursive(wt, val, W, n - 1));
        } else {
            return knapsackRecursive(wt, val, W, n - 1);
        }

    }

    // Memoized solution for 0/1 knapsack

    private static int knapsackMemoized(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (memo[n][W] != -1) {
            return memo[n][W];
        }
        if (wt[n - 1] <= W) {
            return memo[n][W] = Math.max(val[n - 1] + knapsackMemoized(wt, val, W - wt[n - 1], n - 1),
                    knapsackMemoized(wt, val, W, n - 1));
        } else {
            return memo[n][W] = knapsackMemoized(wt, val, W, n - 1);
        }

        // return memo[n][W];
    }

    // DP solution for 0/1 knapsack

    private static int knapsackDP(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][W + 1];

        // initialising 0 when n=0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // initializing 0 when W=0
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];

    }
}