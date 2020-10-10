package practise_qsns;

public class Circular_subarray_sum {

//    Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
//
//    Examples:
//
//    Input: a[] = {8, -8, 9, -9, 10, -11, 12}
//    Output: 22 (12 + 8 - 8 + 9 - 9 + 10)
//
//    Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1}
//    Output:  23 (7 + 6 + 5 - 4 -1 + 10)
//
//    Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
//    Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
//

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }


    static public int maxSubarraySumCircular(int[] A) {
        int maxsum = kadane(A);
        int arraysum = 0;
        for (int i = 0; i < A.length; i++) {
            arraysum += A[i];
            A[i] = -A[i];
        }
        int maxwrapsum = arraysum + kadane(A);
        // before returning also check whether array sum minus max negative number ie maxwrapsum is 0 or not
        return maxwrapsum > maxsum && maxwrapsum != 0 ? maxwrapsum : maxsum;

    }

    static public int kadane(int[] a) {
        int max = a[0], max_ending_here = a[0];
        for (int i = 1; i < a.length; i++) {
            max_ending_here = Math.max(a[i], max_ending_here + a[i]);
            if (max_ending_here > max) max = max_ending_here;

        }
        return max;

    }


}
