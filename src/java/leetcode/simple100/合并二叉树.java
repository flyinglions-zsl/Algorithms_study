package leetcode.simple100;


/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并二叉树 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null){
            if (t2!=null) {
                t1.val += t2.val;
                t1.left = mergeTrees(t1.left, t2.left);
                t1.right = mergeTrees(t1.right, t2.right);
            }

        }else {
            t1=t2;
        }
        return t1;
    }

    public static void print(TreeNode t){
        System.out.println(t!=null?t.val:null);
        if (t.left !=null) {
            print(t.left);
        }
        if (t.right !=null) {
            print(t.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(5);
        t1.left = t2;
        t1.right = new TreeNode(2);
        t2.left = t3;

        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.right = new TreeNode(4);
        a3.left = a4;

        mergeTrees(t1, a1);

        print(t1);


    }

}
