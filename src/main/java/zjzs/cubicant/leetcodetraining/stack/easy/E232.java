package zjzs.cubicant.leetcodetraining.stack.easy;

import java.util.LinkedList;

public class E232 {
    public static void main(String[] args) {
        MyQueue queue = new E232().new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());  // 返回 1
        System.out.println(queue.peek());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }

    class MyQueue {
        private Integer mTopValue; //must be Integer avoid unboxing leading to NullException
        private LinkedList<Integer> mStack = new LinkedList<>();
        private LinkedList<Integer> mTempStack = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (mStack.isEmpty()) {
                mTopValue = x;
            }
            mStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!mStack.isEmpty()) {
                mTempStack.push(mStack.pop());
            }
            int temp = mTempStack.pop();
            mTopValue = mTempStack.peek(); //must store after pop
            while (!mTempStack.isEmpty()) {
                mStack.push(mTempStack.pop());
            }
            return temp;
        }

        /** Get the front element. */
        public int peek() {
            return mTopValue;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mStack.isEmpty();
        }
    }
}
