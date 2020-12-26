package leetcode.simple100;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 **/
public class 二叉树的直径 {

    private static int res = 1;

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static int diameterOfBinaryTree(TreeNode root) {
        //理解为 距离=经过最长节点的个数-1 只要左右子节点不为空就走下去 各自计算两边经过最长节点的个数
        loop(root);
        return res - 1;
    }

    public static int loop(TreeNode node) {
        //只要左右节点有一个就计数，空为0
        int temp = 0;
        if (node == null) {
            return 0;
        }else {
            temp = 1;
        }
        int left = loop(node.left);
        int right = loop(node.right);
        res = Math.max((left + right + 1), res);//某个节点最长为：左右子树长度相加+1(包括了根节点) 然后与之前得到过的长度比较 每次拿最大的即可
        return Math.max(left, right) + temp;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);

        TreeNode a1 = new TreeNode(3);
        a1.left = new TreeNode(7);
        t1.left = t2;
        t1.right = a1;
        t2.left = t3;
        t2.right = t4;

        System.out.println(diameterOfBinaryTree(t1));
    }
}
