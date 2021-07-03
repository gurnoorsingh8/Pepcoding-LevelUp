import java.util.Random;

public class quickSortArray
{
    public static Random rand = new Random();

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int segregate(int[] arr, int pivotIdx, int si, int ei)
    {
        swap(arr, pivotIdx, ei);

        int p = si - 1, itr = si;
        
        while(itr <= ei)
        {
            if(arr[itr] <= arr[ei])
            {
                swap(arr, ++p, itr);
            }
            itr++;
        }

        return p;
    }
    
    public static void quickSort(int[] arr, int si, int ei)
    {
        if(si > ei)
        {
            return;
        }

        int pivotIdx = rand.nextInt(ei - si + 1) +si;
        pivotIdx = segregate(arr, pivotIdx, si, ei);

        quickSort(arr, si, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, ei);
    }

    public static void main(String[] args)
    {
        int[] arr = { -12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3 };
        quickSort(arr, 0, arr.length - 1);
        
        for(int ele : arr)
        {
            System.out.print(ele + " ");
        }
    }
}