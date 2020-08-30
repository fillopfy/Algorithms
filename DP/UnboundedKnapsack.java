import java.util.*;

public class UnboundedKnapsack {

    public static void main(String[] args) {

        int[] wt = new int[] { 1, 50 };
        int[] val = new int[] { 1, 30 };
        int W = 100;
        System.out.println(unboundedKnapsack(wt, val, W));

    }

    // unlimited supply, multiple occurences of same element is allowed
    private static int unboundedKnapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

}