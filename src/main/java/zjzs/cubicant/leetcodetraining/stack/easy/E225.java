package zjzs.cubicant.leetcodetraining.stack.easy;

import java.util.LinkedList;

public class E225 {
    public static void main(String[] args) {
        MyStack obj = new E225().new MyStack();
        obj.push(1);
        System.out.println(obj.pop());
        obj.push(2);
        obj.push(3);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }

    class MyStack {
        private LinkedList<Integer> queue = new LinkedList<>();
        private Integer topValue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
            topValue = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            for (int i = 0; i < queue.size() - 1; ++i) {
                topValue = queue.poll();
                queue.offer(topValue);
            }
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return topValue;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
