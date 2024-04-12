/**
 * QuickSort has an average time complexity of O(n log n) and is widely used due to its efficiency to o sort an array or list efficiently.
 */
public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low -1;

        for(int j = low; j < high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }

}
