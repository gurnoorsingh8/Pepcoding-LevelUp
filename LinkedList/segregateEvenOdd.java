import java.util.Scanner;

public class segregateEvenOdd {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        
        ListNode ep = even;
        ListNode op = odd;
        ListNode curr = head;
        
        while(curr != null)
        {
            if(curr.val % 2 != 0)
            {
                op.next = curr;
                op = op.next;
            }
            else
            {
                ep.next = curr;
                ep = ep.next;
            }
            curr = curr.next;
        }
        
        ep.next = odd.next;
        op.next = null;
        head = even.next;
        
        return head;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}