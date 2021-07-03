import java.util.Scanner;

public class segregatePivotIndex {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode segregate(ListNode head, int pivotIdx) {
    if(head == null || head.next == null)
    {
        return head;
    }
    
    ListNode small = new ListNode(-1);
    ListNode large = new ListNode(-1);
    
    ListNode sp = small, lp = large;
    ListNode curr = head;
    
    ListNode pivotNode = head;
    
    while(pivotIdx-- > 0)
    {
        pivotNode = pivotNode.next;
    }
    
    while(curr != null)
    {
        if(curr != pivotNode && curr.val <= pivotNode.val)
        {
            sp.next = curr;
            sp = sp.next;
        }
        else if(curr != pivotNode)
        {
            lp.next = curr;
            lp = lp.next;
        }
        curr = curr.next;
    }
    
    sp.next = pivotNode;
    pivotNode.next = large.next;
    lp.next = null;
    
    head = small.next;
    
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}