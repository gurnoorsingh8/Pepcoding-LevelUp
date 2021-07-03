import java.util.Scanner;

public class removeNthNode {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
      if (head == null || n <= 0)
      {
          return head;
      }
      
      ListNode slow = head;
      ListNode fast = head;
      
      while(n-- > 0)
      {
          fast = fast.next;
          if(fast == null && n > 0)
          {
              return head;
          }
      }
      
      if(fast == null)
      {
          ListNode rnode = slow;
          head = rnode.next;
          rnode.next = null;
          return head;
      }
      
      while(fast.next != null)
      {
          fast = fast.next;
          slow = slow.next;
      }
      
      ListNode rnode = slow.next;
      slow.next = rnode.next;
      rnode.next = null;
      
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

    int m = scn.nextInt();
    h1 = removeNthFromEnd(h1, m);
    printList(h1);
  }
}