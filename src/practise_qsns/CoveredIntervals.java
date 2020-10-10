package practise_qsns;

import java.util.Arrays;

class Solutions {


    public  int removeCoveredIntervals(int[][] intervals) {

        // O(nlog(n))

        Arrays.sort(intervals, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            }
            return arr1[0] - arr2[0];
        });

        int ans = intervals.length;
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][1] <= max) {
                ans--;
            }
            max = Math.max(max, intervals[i][1]);

        }
        return ans;

    }


    public int mergeIntervals(int[][] intervals) {
        // O(n^2)
        int count = intervals.length;
        for (int i = 0; intervals.length > i; i++) {
            int x = intervals[i][0], y = intervals[i][1];
            for (int j = 0; intervals.length > j; j++) {
                if (i != j) {
                    if (x >= intervals[j][0] && intervals[j][1] >= x && y >= intervals[j][0] && intervals[j][1] >= y) {
                        count--;
                        break;
                    }
                }
            }
        }
        return count;

    }
}