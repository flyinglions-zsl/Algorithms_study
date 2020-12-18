package leetcode.simple100;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 */
public class 最小栈 {

    protected Deque<Integer> stack;
    protected Deque<Integer> min;

    public 最小栈() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        min.push(Math.min(min.peek(),x));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        最小栈 xx = new 最小栈();
        xx.push(-2);
        xx.push(-1);
        xx.push(3);
        System.out.println(xx.top());
        System.out.println(xx.getMin());

        xx.pop();
        System.out.println(xx.top());
        System.out.println(xx.getMin());

    }
}
