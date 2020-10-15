/*package whatever //do not write package name here */
package practise_qsns;
import java.util.*;
import java.lang.*;
import java.io.*;

public class knapsackTabulation{

    public static void main (String[] args) {
        //code
        int t=0;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t-->0) {
            int n=0,w=0;
            n=sc.nextInt();
            w=sc.nextInt();
            int values[]=new int[n];
            int weights[]=new int[w];
            int dp[][]=new int[n+1][w+1];

            for(int i=0;i<n;i++) {
                values[i]=sc.nextInt();

            }
            for(int i=0;i<n;i++) {
                weights[i]=sc.nextInt();

            }
            for(int i=0;i<=n;i++) {
                for(int j=0;j<=w;j++) {

                    if(i==0 || j==0) {
                        dp[i][j]=0;
                    }
                    else if(weights[i-1]>j) {
                        dp[i][j]=dp[i-1][j];
                    }
                    else {

                        dp[i][j]=Math.max(
                                dp[i-1][j],
                                values[i-1]
                                +dp[i-1][j-weights[i-1]]);
                    }
                }
            }

            System.out.println(dp[n][w]);


        }
    }



}