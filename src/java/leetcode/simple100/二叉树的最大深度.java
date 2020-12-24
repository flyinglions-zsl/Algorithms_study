package leetcode.simple100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class 二叉树的最大深度 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * 左深度和右深度比较，+1 代表到达当前层次即+1。
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth,rightDepth)+1;
        }
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int resNum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                //移除掉队列首个 左右节点存在即加入队列，每次循环剔除每个节点，存入子节点。
                TreeNode curr = queue.poll();
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
                size--;
            }
            resNum++;
        }

        return resNum;
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
        TreeNode left3 = new TreeNode(8);
        left2.left = left3;

        //System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }
}
