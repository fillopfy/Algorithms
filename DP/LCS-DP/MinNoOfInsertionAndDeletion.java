import java.util.*;

public class MinNoOfInsertionAndDeletion {
    public static void main(String[] args) {
        String a = "geeke";
        String b = "eke";

        String p = "heap";
        String q = "pea";
        System.out.println(minNoOfInsertionAndDeletion(a, b));// 2 deletions
        System.out.println(minNoOfInsertionAndDeletion(p, q));// 2 deletions + 1 insertion = 3

    }

    private static int minNoOfInsertionAndDeletion(String a, String b) {
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
        int deletion = a.length() - lcs[n][m];
        int insertion = b.length() - lcs[n][m];
        return deletion + insertion;

    }
}