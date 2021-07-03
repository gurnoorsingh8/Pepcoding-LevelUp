import java.util.Scanner;

public class palindrome {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null)
        {
            ListNode forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        head = prev;
        
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode midEle = midNode(head);
        
        ListNode c1 = head;
        ListNode c2 = midEle.next;
        
        midEle.next = null;
        
        c2 = reverse(c2);
        
        boolean flag = true;
        while(c1 != null && c2 != null)
        {
            if(c1.val != c2.val)
            {
                flag = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return flag;
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

        System.out.println(isPalindrome(dummy.next));
    }
}