package DynamicProgramming;

public class EqualPartitionSubset {

    private class Solution {

// Given a non-empty array nums containing only positive integers, find if the array can be partitioned
// into two subsets such that the sum of elements in both subsets is equal.
// Example 1:
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].



        public boolean canPartition(int[] nums) {
            int sum=0;
            for(int i:nums) sum+=i;
            if(sum%2!=0) return false;
            int n=nums.length;
            int target=sum/2;
            boolean[][] dp=new boolean[n+1][target+1];
            for(int k=0;k<=n;k++) {
                dp[k][0]=true;
            }
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=target;j++) {
                    if(j<nums[i-1]) {
                        dp[i][j]=dp[i-1][j];
                    }
                    else {
                        dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }

            return dp[n][target];
        }




    }
}
