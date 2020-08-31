import java.util.*;

public class LCS {
    private static int[][] memo;

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfgr";
        int a = x.length();
        int b = y.length();
        memo = new int[a + 1][b + 1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(lcsRecursive(x, y, a, b));
        System.out.println(lcsMemoized(x, y, a, b));
        System.out.println(lcsTopdownDP(x, y, a, b));
    }

    private static int lcsRecursive(String x, String y, int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        if (x.charAt(a - 1) == y.charAt(b - 1)) {
            return 1 + lcsRecursive(x, y, a - 1, b - 1);
        } else {
            return Math.max(lcsRecursive(x, y, a, b - 1), lcsRecursive(x, y, a - 1, b));
        }
    }

    private static int lcsMemoized(String x, String y, int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (memo[a][b] != -1) {
            return memo[a][b];
        }

        if (x.charAt(a - 1) == y.charAt(b - 1)) {
            return memo[a][b] = 1 + lcsMemoized(x, y, a - 1, b - 1);
        } else {
            return memo[a][b] = Math.max(lcsMemoized(x, y, a, b - 1), lcsMemoized(x, y, a - 1, b));
        }

    }

    private static int lcsTopdownDP(String x, String y, int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int[][] dp = new int[a + 1][b + 1];

        // initialisation
        for (int i = 0; i <= a; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= b; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[a][b];
    }
}