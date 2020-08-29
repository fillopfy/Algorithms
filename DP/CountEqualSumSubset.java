// package DP;

import java.util.*;

public class CountEqualSumSubset {
    public static void main(String[] args) {

        int[] arr = new int[] { 2, 3, 5, 6, 8, 10 };
        int sum = 10;
        System.out.println(countEqualSumSubset(arr, sum));

    }

    private static int countEqualSumSubset(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // if no element(n=0), then not possible
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }

        // for sum=0, there is always 1 susset atleast
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