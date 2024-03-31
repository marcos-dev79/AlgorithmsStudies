/**
 * Selection Sort is a simple sorting algorithm that repeatedly selects the minimum element 
 * from an unsorted portion of the array and moves it to the beginning. 
 * The Selection Sort algorithm has a time complexity of O(n^2), where 'n' is the number of elements in the array. 
 * Although it is not the most efficient sorting algorithm, it can be useful for small data sets or when simplicity is preferred over performance.
 * For larger datasets, more efficient sorting algorithms such as Merge Sort, Quick Sort, or Heap Sort are preferred due to their better time complexities.
 */
public class SelectionSort {
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n-1; i++) {
            int minindex = i;

            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[minindex]) {
                    minindex = j;
                }
            }

            int temp = arr[minindex];
            arr[minindex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main (String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);

        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
