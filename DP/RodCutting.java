import java.util.*;

//Link: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

public class RodCutting {
    public static void main(String[] args) {
        int[] length = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int L = 8;
        System.out.println(rodCutting(length, prices, L));// 22
    }

    private static int rodCutting(int[] length, int[] prices, int L) {
        int n = length.length;
        int[][] dp = new int[n + 1][L + 1];

        // initilisation
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= L; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= L; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], prices[i - 1] + dp[i][j - length[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][L];
    }
}