import java.util.Scanner;

public class segregate012 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode one = new ListNode(-1);
        ListNode zero = new ListNode(-1);
        ListNode two = new ListNode(-1);
        ListNode op = one, zp = zero, tp = two, curr = head;

        while (curr != null) {
            if (curr.val == 1) {
                op.next = curr;
                op = op.next;
            } else if (curr.val == 0) {
                zp.next = curr;
                zp = zp.next;
            } else {
                tp.next = curr;
                tp = tp.next;
            }
            curr = curr.next;
        }

        op.next = two.next;
        zp.next = one.next;
        tp.next = null;

        head = zero.next;
        zero.next = one.next = two.next = null;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}