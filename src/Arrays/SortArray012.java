package Arrays;

import java.util.Scanner;

public class SortArray012 {


    // Detuch national flag algorithm
        public static void main (String[] args) {

            int t=0;
            Scanner sc=new Scanner(System.in);
            t=sc.nextInt();
            while(t-->0) {
                int n=0;
                n=sc.nextInt();
                int[] arr=new int[n];
                for(int i=0;i<n;i++) {
                    arr[i]=sc.nextInt();
                }
                int low=0,mid=0,high=arr.length-1;
                while(mid<=high) {
                    if(arr[mid]==0) {
                        int temp=arr[low];
                        arr[low]=arr[mid];
                        arr[mid]=temp;
                        low++;
                        mid++;
                    }
                    else if(arr[mid]==1) {
                        mid++;
                    }
                    else {
                        int temp=arr[mid];
                        arr[mid]=arr[high];
                        arr[high]=temp;
                        high--;
                    }
                }
                for(int i:arr) System.out.print(i+" ");



        }}
}
