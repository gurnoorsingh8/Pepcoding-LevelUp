import java.util.ArrayList;

public class tree
{
    public static class TreeNode
    {
        int val = 0;
        Node left = null;
        Node right = null;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int Maximum(TreeNode root) {
        return root == null ? -(int) 1e9 : Math.max(Math.max(Maximum(root.left), Maximum(root.right)), root.val);
    }

    public static boolean findData(TreeNode root, int data)
    {
        if(root == null)
        {
            return false;
        }
        
        if(root.val == data)
        {
            return true;
        }

        return findData(root.left, data) || findData(root.right, data);
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int data)
    {
        if(root == null)
        {
            return new ArrayList<>();
        }

        if(root.val == data)
        {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        ArrayList<TreeNode> left = nodeToRootPath(root.left, data);
        if(left.size() != 0)
        {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath(root.right, data);
        
        if(right.size() != 0)
        {
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

    public static void rootToLeafPath(TreeNode root, ArrayList<Integer> smallAns, ArrayList<ArrayList<Integer>> ans)
    {
        if(root == null)
        {
            return;
        }

        if(root.left == null || root.right == null)
        {
            
        }
    }
}