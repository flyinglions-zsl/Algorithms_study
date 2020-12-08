package leetcode.simple100;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class 翻转二叉树 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        /*TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);*/

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 先序
     * @param root
     */
    public static void preOrderRec(TreeNode root){
        if(root!=null){
            System.out.print(root.val+"  ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    /**
     * @param root 树根节点
     * 递归中序遍历
     */
    public static void inOrderRec(TreeNode root){
        if(root!=null){
            preOrderRec(root.left);
            System.out.println(root.val);
            preOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(3);
        left.left = left1;
        left.right = right1;
        TreeNode left2 = new TreeNode(6);
        TreeNode right2 = new TreeNode(9);
        right.left = left2;
        right.right = right2;

        root = invertTree(root);

        inOrderRec(root);
    }
}
