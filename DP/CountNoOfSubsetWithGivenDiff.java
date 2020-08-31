import java.util.*;

public class CountNoOfSubsetWithGivenDiff {
    public static void main(String[] args) {

        int[] arr = new int[] { 1, 1, 2, 3 };
        int diff = 1;
        System.out.println(countNoOfSubsetWithGivenDiff(arr, diff));

    }

    private static int countNoOfSubsetWithGivenDiff(int[] arr, int diff) {
        int n = arr.length;
        int total = 0;
        for (int i : arr)
            total += i;

        // two subsets s1-s2=diff
        // also s1+s2=total
        // Adding above two equations, we get
        // 2*s2=diff+total
        // s2=diff+total/2;
        // count subsets with sum s2 in arr and that will be the count of subsets with
        // given diff

        int sum = (diff + total) / 2;

        int[][] dp = new int[n + 1][sum + 1];

        // for sum=0
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }

        // for no of element in arr as 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}