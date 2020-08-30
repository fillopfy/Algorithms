import java.util.*;

public class MinSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 6, 11, 5 };
        System.out.println(minSubsetSumDiff(arr));
    }

    private static int minSubsetSumDiff(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        // size
        int n = arr.length;

        // total sum
        int range = 0;
        for (int i : arr)
            range += i;

        // basically we divide the arr int two subsets s1 and s2 such that |s1-s2| is
        // min
        // s1=range-s2 is we want |range-s2-s2|=|range-2*s2| minimum
        // so we use subset problem to find subset with sum 0 to range/2 and put it in
        // list and check using above formula which gives minimum

        // dp

        boolean[][] dp = new boolean[n + 1][range + 1];

        // initialisation
        for (int j = 1; j <= range; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // dp subproblems buildup
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // last row of dp with truthy values and in range, range/2
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j <= range / 2; j++) {
            if (dp[n][j]) {
                list.add(j);
            }
        }

        // find min
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, range - 2 * list.get(i));
        }

        return min;

    }
}