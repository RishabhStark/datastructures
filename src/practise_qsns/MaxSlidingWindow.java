package practise_qsns;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {


    public static void main(String[] args) {
Solution solution=new Solution();
int ans[]=solution.maxSlidingWindow(new int[] {2,3,1,5,7,1,2,5,4,3},3);
for(int i:ans) {
    System.out.print(i+" ");
}

    }

   static class Solution {
        public int[] maxSlidingWindow(int[] a, int k) {
            int i=0;
            Deque<Integer> deque=new LinkedList<>();
            int n=a.length;
           int  []ans=new int[n-k+1];
            for(;i<k;i++) {
                while (!deque.isEmpty() && a[deque.peekLast()]<=a[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
            for(;i<n;i++) {
                ans[i-k]=a[deque.peekFirst()];
                while(!deque.isEmpty() && deque.peekFirst()<=i-k) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && a[deque.peekLast()]<=a[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);

            }
            ans[i-k]=a[deque.peekFirst()];
            return ans;

        }
    }
}
