import java.util.*;

public class PrintLongestCommonSequence {
    public static void main(String[] args) {
        String a = "ababdddd";
        String b = "abdddd";
        printLongestCommonSequence(a, b);
    }

    private static void printLongestCommonSequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n == 0 || m == 0) {
            System.out.println("No common Sequence!");
            return;
        }

        int[][] dp = new int[n + 1][m + 1];

        // initialisation
        // first row
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        // first col
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder s = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                s.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println(s.reverse().toString());

    }
}