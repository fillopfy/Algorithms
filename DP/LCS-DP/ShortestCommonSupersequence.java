import java.util.*;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String a = "geeke";
        String b = "eke";

        String p = "aggtab";
        String q = "gxtxayb";
        System.out.println(shortestCommonSupersequence(a, b));// 5
        System.out.println(shortestCommonSupersequence(p, q));// 9
    }

    private static int shortestCommonSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n == 0 || m == 0) {
            return n + m;
        }

        int[][] lcs = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return n + m - lcs[n][m];

    }
}