package Arrays;
import java.util.*;
public class CountPairwithGivenSum {
    int getPairsCount(int[] arr, int n, int k) {
//        Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum
//        is equal to K.
//        Example 1:
//        Input:
//        N = 4, K = 6
//        arr[] = {1, 5, 7, 1}
//        Output: 2
//        Explanation:
//        arr[0] + arr[1] = 1 + 5 = 6
//        and arr[1] + arr[3] = 5 + 1 = 6.



        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = k - arr[i];
            if (diff > 0) {
                if (map.containsKey(diff)) {
                    cnt += map.get(diff);
                }
                int temp = 0;
                if (map.get(arr[i]) == null) {
                    temp = 1;

                } else {
                    temp = 1 + map.get(arr[i]);
                }
                map.put(arr[i], temp);
            }

        }
        return cnt;
    }
}
