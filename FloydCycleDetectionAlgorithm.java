/*
* Floyd's Cycle Detection Algorithm, also known as the "tortoise and hare" algorithm, 
* is a popular algorithm used to detect cycles in a linked list or any cyclic sequence. 
* It's particularly efficient in terms of both time and space complexity.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class FloydCycleDetectionAlgorithm {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
    
        FloydCycleDetectionAlgorithm floydCycleDetectionAlgorithm = new FloydCycleDetectionAlgorithm();
    
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Cycle
    
        boolean hasCycle = floydCycleDetectionAlgorithm.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}
