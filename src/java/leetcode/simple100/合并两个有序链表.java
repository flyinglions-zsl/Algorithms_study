package leetcode.simple100;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class 合并两个有序链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 递归法
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 思路： 每次拿head节点比较，判断哪个大，再用小的next节点继续递归判断，直到拿到最小的值，最后一次为null的肯定是上一次数据对比为小的，这时返回的node = 小的，node.next = 大的
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        if (l1 == null ) {
            return l2;
        }
        if (l2 == null ) {
            return l1;
        }
        if (l1.val < l2.val) {
            node = l1;
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node = l2;
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }

    //迭代法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        //首先指向同一个 后面每次比较都去掉小的一方的head节点，直到有一个为null
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node12 = new ListNode(5);
        ListNode node13 = new ListNode(8);
        node1.next = node12;
        node12.next = node13;

        ListNode node2 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(7);
        node2.next = node22;
        node22.next = node23;

        ListNode res = mergeTwoLists(node1, node2);

        while (res != null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
