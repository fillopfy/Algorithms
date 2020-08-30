import java.util.*;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 2, 3 };
        int sum = 1;
        System.out.println(targetSum(arr, sum));
    }

    // in target sum, we have to add one sign(+/-) before every element of arr and
    // add them to get required target sum and count such subsets(possibilities)
    // similar to countNoOfSubsetsWithGivenDiff

    private static int targetSum(int[] arr, int sum) {
        int n = arr.length;
        int total = 0;
        for (int i : arr)
            total += i;
        int val = sum + total / 2;

        int[][] dp = new int[n + 1][val + 1];

        for (int j = 1; j <= val; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= val; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][val];
    }

}