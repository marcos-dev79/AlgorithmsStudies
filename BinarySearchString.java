public class BinarySearchString {
    public static int binarySearchRecursive(String[] arr, String target, int left, int right) {

        if(left > right){
            return -1;
        }

        int mid = left + (right - left) / 2;

        int compareResult = target.compareTo(arr[mid]);

        if(compareResult == 0) {
            return mid;
        }else if(compareResult < 0) {
            return binarySearchRecursive(arr, target, left, mid -1);
        }else {
            return binarySearchRecursive(arr, target, mid+1, right);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry", "fig"};
        String target = "cherry";

        int result = binarySearchRecursive(arr, target, 0, arr.length-1);
        if(result != -1) {
            System.out.println("Target found at index: " + result);
        }else{
            System.out.println("Target not found");
        }
    }
}
