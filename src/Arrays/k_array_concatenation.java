package Arrays;


import java.util.Scanner;

class Codechef {
        public static void main(String[] args) throws java.lang.Exception {
            try {
                int t = 0;
                Scanner sc = new Scanner(System.in);
                t = sc.nextInt();
                while (t-- > 0) {
                    int n = 0, k = 0;
                    n = sc.nextInt();
                    k = sc.nextInt();
                    int arr[] = new int[n];
                    for (int i = 0; i < n; i++) {
                        arr[i] = sc.nextInt();
                    }
                    System.out.println(maxSubKSum(arr, k));

                }
            } catch (Exception e) {
            }
        }


        static void arrayConcatenate(int arr[], int b[],
                                     int k) {

            int j = 0;
            while (k > 0) {

                for (int i = 0; i < arr.length; i++) {
                    b[j++] = arr[i];
                }
                k--;
            }
        }

        // Function to return the maximum
        // subarray sum of arr[]
        static long maxSubArrSum(int a[]) {
            int size = a.length;
            long max_so_far = a[0],
                    max_ending_here = a[0];
            for (int i = 1; i < a.length; i++) {
                max_ending_here = Math.max(max_ending_here + a[i], a[i]);
                if (max_ending_here > max_so_far) {
                    max_so_far = max_ending_here;
                }
            }

            for (int i = 0; i < size; i++) {

            }
            return max_so_far;
        }

        // Function to return the maximum sub-array
        // sum of the modified array
        static long maxSubKSum(int arr[], int k) {
            long arrSum = 0;
            long maxSubArrSum = 0;

            int b[] = new int[(2 * arr.length)];

            // Concatenating the array 2 times
            arrayConcatenate(arr, b, 2);

            // Finding the sum of the array
            for (int i = 0; i < arr.length; i++)
                arrSum += arr[i];


            if (k > 1) {
                if (arrSum < 0)
                    maxSubArrSum = maxSubArrSum(b);

                    // If sum is greater than zero
                else
                    maxSubArrSum = maxSubArrSum(b) +
                            (k - 2) * arrSum;
            }
            else {
                maxSubArrSum = maxSubArrSum(arr);
            }

            return maxSubArrSum;
        }


    }
