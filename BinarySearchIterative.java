/*
* Binary Search is a widely used searching algorithm that efficiently finds the position of a target value 
* within a sorted array. 
* It works by repeatedly dividing the search interval in half.
*/  
public class BinarySearchIterative {
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == target) {
                return mid;
            }
            else if (target < arr[mid]) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 11;

        int result = binarySearchIterative(arr, target);

        if(result != -1) {
            System.out.println("Target found at index: " + result);
        }
        else {
            System.out.println("Target not found");
        }
    }
}
