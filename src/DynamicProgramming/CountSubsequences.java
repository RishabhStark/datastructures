package DynamicProgramming;

import java.util.Scanner;

public class CountSubsequences {
    // Codeforces Problem
    // "QAQ" is a word to denote an expression of crying. Imagine "Q" as eyes with tears and "A" as a mouth.
    //Now Diamond has given Bort a string consisting of only uppercase English letters of length n.
    // There is a great number of "QAQ" in the string (Diamond is so cute!).
    //Bort wants to know how many subsequences "QAQ" are in the string Diamond has given.
    // Note that the letters "QAQ" don't have to be consecutive, but the order of letters should be exact.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s,p="QAQ";
        s=sc.next();
        int[][] dp=new int[4][s.length()+1];
        for(int i=0;i<s.length();i++) {
            dp[0][i]=1;
        }
        for(int i=1;i<4;i++) {
            dp[i][0]=0;
        }

        for(int i=1;i<4;i++) {
            for(int j=1;j<=s.length();j++) {
                if(s.charAt(j-1)==p.charAt(i-1)) {
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }
                else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        System.out.println(dp[3][s.length()]);
    }
}
