package DynamicProgramming;

public class LCSubstring {

    public static void main(String[] args) {
        String x = "abcdef", y = "bcdef";
        int n = x.length(), m = y.length();
        System.out.println(lcs(x, y, n, m));
    }

    static int count(String x, String y, int n, int m, int count) {
        // recursion
        if (n == 0 || m == 0) return count;
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            count = count(x, y, n - 1, m - 1, count + 1);
            return count;
        }

        count = Math.max(Math.max(count(x, y, n - 1, m, count), count(x, y, n, m - 1, count)), count);
        return count;

    }

    static int lcs(String x, String y, int n, int m) {
        // tabulation dp
        int result = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
