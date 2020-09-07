import java.util.*;

public class SequencePatternMatching {
    public static void main(String[] args) {

        String a = "axy";
        String b = "adxcpy";
        System.out.println(sequencePatternMatching(a, b) ? "Yes" : "No");

    }

    // if first string is a sequence in second string(completely lying in sec
    // string)
    private static boolean sequencePatternMatching(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n == 0 || m == 0) {
            return false;
        }

        // idea is to take out longest common subsequence of two string and match it
        // with first string(length will also work)
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

        return n == lcs[n][m];
    }
}