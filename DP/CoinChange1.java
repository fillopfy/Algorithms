import java.util.*;

public class CoinChange1 {
    public static void main(String[] args) {
        int[] coin = new int[] { 1, 2, 3 };
        int sum = 5;
        System.out.println(coinChange1(coin, sum));
    }

    // maximum no of ways coin change possible
    private static int coinChange1(int[] coin, int sum) {
        int n = coin.length;

        int[][] dp = new int[n + 1][sum + 1];

        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coin[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}