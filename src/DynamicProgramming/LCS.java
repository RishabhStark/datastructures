package DynamicProgramming;

import java.util.Arrays;

public class LCS {


    public static void main(String[] args) {
        String x = "axytzmno", y = "axytzxno";
        int n = x.length(), m = y.length();
       int ans=countLCS(x,y,n,m);
        System.out.println(ans);
    }

    static int countLCS(String x, String y, int n, int m, int[][] dp) {

        // recursive + memoization
//        O(n*m)
        if (n == 0 || m == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            dp[n][m] = countLCS(x, y, n - 1, m - 1, dp) + 1;
            return dp[n][m];
        } else {
            dp[n][m] = Math.max(countLCS(x, y, n, m - 1, dp), countLCS(x, y, n - 1, m, dp));
            return dp[n][m];
        }
    }

    static int countLCS(String x, String y, int n, int m) {
        // tabulation dp
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j==0) {
                    dp[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
       int i=n,j=m;
       StringBuilder s=new StringBuilder();
       while(i>0 || j>0) {
    	   if(x.charAt(i-1)==y.charAt(j-1)) {
             s.append(x.charAt(i-1));
             i--;
             j--;
           }
    	   else {
    		   if(dp[i][j-1]>dp[i-1][j]) {
    		   j--;
    		   }
    		   else {
    			   i--;
    		   }
    	   }
       }
       s.reverse();
       System.out.println(s);
        
        return dp[n][m];

    }

}
