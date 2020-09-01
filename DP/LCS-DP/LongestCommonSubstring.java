import java.util.*;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String a = "abppp";
        String b = "bappp";
        System.out.println(longestCommonSubstring(a, b));

    }

    private static int longestCommonSubstring(String a, String b) {

        int m = a.length();
        int n = b.length();

        if (m == 0 || n == 0)
            return 0;

        int[][] dp = new int[m + 1][n + 1];
        // initialisation

        // first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        // first row
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m][n];

    }
}