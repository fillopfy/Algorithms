import java.util.*;

public class LongestPallindromicSubsequence {
    public static void main(String[] args) {
        String a = "agbcba";
        System.out.println(longestPallindromicSubsequence(a));//5

    }

    private static int longestPallindromicSubsequence(String a) {
        String b = (new StringBuilder(a)).reverse().toString();
        int n = a.length();

        int[][] lps = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lps[i][j] = lps[i - 1][j - 1] + 1;
                } else {
                    lps[i][j] = Math.max(lps[i - 1][j], lps[i][j - 1]);
                }
            }
        }

        return lps[n][n];

    }
}