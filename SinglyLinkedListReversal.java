/* Reversing a singly linked list involves changing the direction of the pointers in each node so that the last node becomes the first node, 
* the second-to-last node becomes the second node, and so on, until the first node becomes the last node.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SinglyLinkedListReversal {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
        return head;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedListReversal reversal = new SinglyLinkedListReversal();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list: ");
        reversal.printList(head);

        // Reversal
        head = reversal.reverseList(head);
        System.out.println("Reversed list: ");
        reversal.printList(head);
    }
}
