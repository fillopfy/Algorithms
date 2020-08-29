// package DP;

import java.util.*;

public class EqualSumPartition {
    public static void main(String[] args) {

        int[] arr = new int[] { 1, 5, 11, 5 };
        System.out.println(equalSumPartition(arr) ? "Yes" : "No");

    }

    private static boolean equalSumPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // false if no element is given(n=0)
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // true if sum=0 irrespective of n
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