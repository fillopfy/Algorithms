import java.util.*;

public class MinNoOfInsertionInStringToMakeItPallindrome {
    public static void main(String[] args) {

        String a = "apa";// 0
        System.out.println(minNoOfInsertionInStringToMakeItPallindrome(a));

    }

    private static int minNoOfInsertionInStringToMakeItPallindrome(String a) {
        String b = (new StringBuilder(a)).reverse().toString();
        int n = a.length();

        if (n == 0)
            return 0;

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

        return n - lps[n][n];
    }
}