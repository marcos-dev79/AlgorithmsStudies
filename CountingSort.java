import java.util.Arrays;

/**
 * Counting Sort is an efficient sorting algorithm that operates in linear time complexity O(n+k), 
 * where n is the number of elements in the input array and k is the range of the input (maximum element - minimum element + 1). 
 * Counting Sort is particularly useful when the range of input values is not significantly greater than the number of elements in the array. 
 * The basic idea behind Counting Sort is to count the occurrences of each unique element in the input array and then use this information 
 * to place each element in its correct sorted position.
 */
public class CountingSort {
    
    public static void countingSort(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }

        int max = Arrays.stream(array).max().getAsInt();
        int[] countArray = new int[max + 1];

        for(int num : array) {
            countArray[num]++;
        }

        for(int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }

        int[] tempArray = new int[array.length];
        for(int i = array.length - 1; i>= 0; i--) {
            tempArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }

        System.arraycopy(tempArray, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,8,3,3,1};
        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
