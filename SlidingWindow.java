import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*The sliding window technique is a commonly used algorithmic approach for solving problems involving arrays or strings 
* where you need to find a subset (window) of elements that satisfies certain conditions.
*/
public class SlidingWindow {

    public static List<Integer> findSubArray(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0 || k <= 0) {
            return result;
        }
        
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && deque.peek() < i -k +1) {
                deque.poll();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.offer(i);

            if(i >= k -1) {
                result.add(nums[deque.peek()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        List<Integer> result = findSubArray(nums, k);

        System.out.println("Maximum elements in each sliding window of size " + k +" : " + result);
    }
}
