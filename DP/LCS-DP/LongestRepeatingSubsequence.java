import java.util.*;

//Problem Link: https://www.geeksforgeeks.org/longest-repeated-subsequence/
public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String a = "aabebcdd";
        System.out.println(longestRepeatingSubsequence(a));
    }

    private static int longestRepeatingSubsequence(String a) {
        int n = a.length();
        String b = a;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];

    }
}