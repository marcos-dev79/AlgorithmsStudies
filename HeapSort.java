/**
 * Heap Sort
 * a comparison-based sorting algorithm that uses a binary heap data structure to sort elements. 
 * It works by first building a heap from the input array and then repeatedly extracting the maximum (for ascending order) 
 * or minimum (for descending order) element from the heap and placing it at the end of the array. 
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for(int i = n/2 -1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for(int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Change the comparison to change the sorting order
        if(left < n && arr[left] > arr[largest])
            largest = left;

        // Change the comparison to change the sorting order
        if(right < n && arr[right] > arr[largest])
            largest = right;

        if(largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 17, 22};
        heapSort(arr);
        printArray(arr);
    }
    
}
