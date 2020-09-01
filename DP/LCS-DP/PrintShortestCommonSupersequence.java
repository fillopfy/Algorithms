import java.util.*;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        String a = "geeke";
        String b = "eke";

        String p = "aggtab";
        String q = "gxtxayb";
        printShortestCommonSupersequence(a, b);// geeke , 5
        printShortestCommonSupersequence(p, q);// agxgtxayb , 9
    }

    private static void printShortestCommonSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n == 0 || m == 0) {
            System.out.println(a + b);
            return;
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

        int i = n, j = m;
        StringBuilder s = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                s.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (lcs[i - 1][j] >= lcs[i][j - 1]) {
                    s.append(a.charAt(i - 1));
                    i--;
                } else {
                    s.append(b.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            s.append(a.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            s.append(b.charAt(j - 1));
            j--;
        }

        System.out.println(s.reverse().toString());
        System.out.println(s.reverse().toString().length());

    }
}