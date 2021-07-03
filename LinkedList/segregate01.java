import java.util.Scanner;

public class segregate01 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        
        ListNode p1 = zero;
        ListNode p2 = one;
        ListNode curr = head;
        
        while(curr != null)
        {
            if(curr.val == 0)
            {
                p1.next = curr;
                p1 = p1.next;
            }
            else
            {
                p2.next = curr;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        
        p1.next = one.next;
        p2.next = null;
        head = zero.next;
        
        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate01(h1);
        printList(h1);
    }
}