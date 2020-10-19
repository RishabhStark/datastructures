package Arrays;
//Move all negative numbers to beginning and positive to end without extra space and
// order of elements doesn't matter
public class Negativepositive {
    public static void main(String[] args) {

        // Two pointer solution
        int[] arr={ -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int left=0,right=arr.length-1;
        while (left<=right) {
            if(arr[right]<0 && arr[left]<0) {
               left++;
            }

            else if(arr[left]>0 && arr[right]<0) {
                int temp=arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
                left++;
                right--;
            }
            else if(arr[left]>0 && arr[right]>0) {
                right--;
            }
            else {
                left++;
                right--;
                // left negative and right positive
            }
        }
        for(int i:arr) System.out.print(i+" ");
    }
}
