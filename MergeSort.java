/**
 * The merge sort is a sorting algorithm that uses a divide-and-conquer strategy to sort an array of elements. 
 * It is an efficient sorting algorithm, with an average time complexity of O(n log n).
 * The merge sort algorithm works by recursively dividing the input array into two halves until each half contains only one element or is empty. 
 * Then, it merges the sorted subarrays back together to produce the final sorted array.
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, 10, 1, 8, 7, 5, 2};
        mergeSort(arr);

        for(int i: arr) {
            System.out.print(i + " ");
        }
        
    }

    public static void mergeSort(int[] array) {
        if(array == null || array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        System.arraycopy(array, 0, leftArray, 0, mid);

        if(array.length - mid >= 0) {
            System.arraycopy(array, mid, rightArray, 0, array.length - mid);
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int i = 0, j = 0, k = 0;

        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }

        while(i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while(j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

}
