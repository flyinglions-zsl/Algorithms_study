package leetcode.simple100;

import java.util.List;

/**
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class 反转链表 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode reverseList(ListNode head) {
        /**
         * 由后往前看，pre 代表当前（后面移动的next），curr代表之前的节点
         */
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            //得到next节点后面的链子 不做修改；每次遍历都往目标链子curr里放链子的首节点，并作为pre的next节点.如 1 -》 null； 2 -》1 -》null
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            //拿剩下的节点继续遍历
            pre = temp;
        }
        return curr;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        /**
         * 遍历next节点；之会到4-》5-》null
         */
        ListNode tt = reverseList2(head.next);
        /**
         * 4-》5-》4-》5循环
         */
        head.next.next = head;
        /**
         * 4.next 为null 切断与5的循环 达到5-》4-》null 且返回
         */
        head.next = null;
        return tt;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode res = reverseList2(head);

        while (res != null){
            System.out.println(res.val);
            res=res.next;
        }

    }


}
