import java.util.Random;
public class quickSortLinkedList
{
    public class ListNode
    {
        int val = 0;
        ListNode next = null;

        ListNode(int val)
        {
            this.val = val;
        }
    }

    Random rand = new Random();

    public int length(ListNode head)
    {
        if(head == null)
        {
            return 0;
        }

        ListNode length = head;
        int count = 0;

        while(length-- > 0)
        {
            length = length.next;
            count++;
        }
    }

    public ListNode[] segregate(ListNode head, int pivotIdx)
    {
        // if(head == null || head.next == null)
        // {
        //     return head;
        // }

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);

        ListNode sp = small, lp = large, curr = head;
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

        sp.next = null;
        pivotNode.next = null;
        lp.next = null;

        return new ListNode[] {small.next, pivotNode, large.next};
    }

    public ListNode[] mergeElements(ListNode[] left, ListNode pivotNode, ListNode[] right)
    {
        ListNode head = null;
        ListNode tail = null;

        if(left[0] != null && right[0] != null)
        {
            head = left[0];
            tail = right[1];
            left[1] = pivotNode;
            pivotNode.next = right[0];
        }
        else if(right[0] != null)
        {
            head = pivotNode;
            tail = right[1];
            pivotNode.next = right[0];
        }
        else if(left[0] != null)
        {
            head = left[0];
            tail = pivotNode;
            left[1].next = pivotNode;
        }
        else
        {
            head = tail = pivotNode;
        }

        return new ListNode[] {head, tail};
    }

    public ListNode[] quickSort(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return new ListNode[] {head, head};
        }

        int len = length(head);
        int pivotIdx = rand.nextInt(len);
        ListNode[] segregatedElements = segregate(head, pivotIdx);

        ListNode[] left = quickSort(segregatedElements[0]);
        ListNode[] right = quickSort(segregatedElements[2]);

        return mergeElements(left, segregatedElements[1], right);
    }

    public ListNode sort(ListNode head)
    {
        return quickSort(head)[0];
    }


}