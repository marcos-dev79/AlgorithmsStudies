public class BinarySearch {
    
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;

        if(arr[mid] == target) {
            return mid;
        }
        else if (target < arr[mid]) {
            return binarySearchRecursive(arr, target, left, mid -1);
        }
        else {
            return binarySearchRecursive(arr, target, mid+1, right);
        }
        
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 11;

        int result = binarySearchRecursive(arr, target, 0, arr.length-1);
                if(result != -1) {
            System.out.println("Target found at index: " + result);
        }else{
            System.out.println("Target not found");
        }
    }
}
