package leetcode.simple100;

/**
 *编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,2,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *

 */
public class 相交链表 {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //1。获取每个链表的长度
        int lenA = 0, lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA!=null){
            nodeA = nodeA.next;
            lenA++;
        }

        while (nodeB!=null){
            nodeB = nodeB.next;
            lenB++;
        }
        //2。根据长度，移动长的指针两长度的差值(与短的head保持一致)
        int distance = lenA - lenB;
        nodeA = headA;
        nodeB = headB;
        //可能A长，可能B长,让长的走 distance步
        if (distance > 0){
            while (distance!=0){
                nodeA = nodeA.next;
                distance--;
            }
        }else {
            while (distance!=0){
                nodeB = nodeB.next;
                distance++;
            }
        }
        //3。两链表对等比较，相遇(相等)则返回
        while (nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(8);
        ListNode node14 = new ListNode(4);
        ListNode node15 = new ListNode(5);
        node1.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        ListNode node2 = new ListNode(5);
        ListNode node22 = new ListNode(0);
        ListNode node23 = new ListNode(1);
        node2.next = node22;
        node22.next = node23;
        node23.next = node13;

        ListNode res = getIntersectionNode(node1, node2);


         System.out.println(res.val);

    }
}
