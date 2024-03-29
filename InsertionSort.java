/**
 * Insertion Sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. 
 * It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. 
 * However, it is efficient for small lists or nearly sorted lists.
 */
public class InsertionSort {
    public static void InsertionSort(int[] array) {
        int n = array.length;

        for(int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4};
        InsertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
