public class KadaneAlgorithm {
    public static int kadane(int[] arr) {
        int maxCurrent = arr[0];
        int maxGlobal = arr[0];

        for(int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        return maxGlobal;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum subarray: " + kadane(arr));
    }
}
