class Solution {
     int res=1;
    
//Given a string s, return the longest palindromic substring in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.


  
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) {
            dp[i][i]=1;
          
        }
        int start=0,end=0;
        
        for(int i=n-2;i>=0;i--) {
            for(int j=i+1;j<n;j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(dp[i+1][j-1]==j-i-1)
                    dp[i][j]=2+dp[i+1][j-1];
                    
                }
              
                if(res<dp[i][j]) {
                    start=i;
                    end=j;
                    res=dp[i][j];
                }
                
            }
            
        }
        
        return s.substring(start,end+1);
      
        
    }
    
 
     
}
