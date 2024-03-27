import java.util.Random;
/*
 * Quick Select is an algorithm used to find the k-th smallest (or largest) element in an unordered list or array. 
 * It's an efficient algorithm with an average time complexity of O(n), where n is the number of elements in the array.
 */
public class QuickSelect {
    
    public static int quickSelect(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length -1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if(left == right) {
            return arr[left];
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if(k == pivotIndex) {
            return arr[k];
        } else if( k < pivotIndex ) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {

        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;

        for(int i = left; i < right; i++) {
            if(arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4};
        int k = 3;
        int result = quickSelect(arr, k);

        //int n = arr.length;
        //int kthLargest = quickSelect(arr, n - k + 1); // Adjust k

        System.out.println(k +"th smallest element: " + result);
    }
}
