package practise_qsns;

import java.util.Arrays;

public class kadane_algo {

    public static void main(String[] args) {
        int []arr=new int[] {-2,-1,-5,-6};
        kadane(arr);
    }

    static void  kadane(int[] arr) {
        int []max_sum=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            max_sum[i]=0;
        }
        max_sum[0]=arr[0];
        for(int i=1;i<arr.length;i++) {
            int maxo=Integer.max(arr[i],max_sum[i-1]+arr[i]);
            max_sum[i]=maxo;


        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            if(max_sum[i]>max) {
                max=max_sum[i];
            }
        }
        System.out.println(max);
    }
}
