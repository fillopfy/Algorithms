import java.util.*;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coin = new int[] { 1, 2, 3, 5 };
        int sum = 8;
        System.out.println(coinChange2(coin, sum));

    }

    // minimum number of coins to get required sum
    private static int coinChange2(int[] coin, int sum) {
        int n = coin.length;
        int[][] dp = new int[n + 1][sum + 1];

        // initialization

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        // Twist
        for (int j = 1; j <= sum; j++) {
            if (j % coin[0] == 0) {
                dp[1][j] = j / coin[0];
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coin[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coin[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}