/*package whatever //do not write package name here */
package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

class KnapsackMemoization {

    public static void main(String[] args) {
        //code
        int t = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            int n = 0, w = 0;
            n = sc.nextInt();
            w = sc.nextInt();
            int values[] = new int[n];
            int weights[] = new int[n];
            int dp[][] = new int[n + 1][w + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            for (int i = 0; i < n; i++) {
                values[i] = sc.nextInt();

            }
            for (int i = 0; i < n; i++) {
                weights[i] = sc.nextInt();

            }
            System.out.println(knapsack(values, weights, w, n - 1, dp));
            for (int[] row : dp) {
                for (int i : row) System.out.print(i + " ");
                System.out.println();
            }

        }
    }


    public static int knapsack(int[] values, int[] weights, int w, int n, int dp[][]) {
        // memoization
        if (w == 0 || n < 0) {
            return 0;
        }
        if (dp[n][w] != -1) return dp[n][w];

        if (weights[n] > w) {
            dp[n][w] = knapsack(values, weights, w, n - 1, dp);
            return dp[n][w];
        }

        dp[n][w] = Math.max(knapsack(values, weights, w, n - 1, dp), values[n] +
                knapsack(values, weights, w - weights[n], n - 1, dp));
        return dp[n][w];

    }

}