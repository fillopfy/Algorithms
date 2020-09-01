import java.util.*;

public class MinNoOfDeletionInStringToMakeItPallindrome {
    public static void main(String[] args) {
        String a = "agbcba";
        System.out.println(MinNoOfDeletionInStringToMakeItPallindrome(a));// 1

    }

    private static int MinNoOfDeletionInStringToMakeItPallindrome(String a) {
        String b = (new StringBuilder(a)).reverse().toString();
        int n = a.length();

        // we count the longestPallindromicSubsequence
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

        return a.length() - lps[n][n];

    }
}