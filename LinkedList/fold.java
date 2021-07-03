import java.util.Scanner;

public class fold {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null)
        {
            ListNode forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }

    public static void fold(ListNode head) {
        ListNode c1 = head;
        ListNode mid = mid(c1);
        
        ListNode c2 = mid.next;
        mid.next = null;
        
        c2 = reverse(c2);
        
        while(c1 != null && c2 != null)
        {
            ListNode f1 = c1.next; 
            ListNode f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}