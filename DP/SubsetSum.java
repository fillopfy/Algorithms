// package DP;

import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {

        int[] arr = new int[] { 2, 3, 7, 8, 10 };
        int sum = 11;

        System.out.println(subsetSum(arr, sum) ? "Yes" : "No");

    }

    private static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // false if no element is given i.e. i=0(n=0)
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // true if sum is 0(j=0) irrespective of n
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];

    }
}