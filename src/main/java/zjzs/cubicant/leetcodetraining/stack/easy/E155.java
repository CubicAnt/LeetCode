package zjzs.cubicant.leetcodetraining.stack.easy;

public class E155 {
    public static void main(String[] args) {
        MinStack obj = new E155().new MinStack();
        obj.push(3);
        obj.push(4);
        obj.pop();
        obj.push(2);
        obj.push(8);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(10);
        obj.pop();
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

    class MinStack {
        private Node dummyHead;

        /** initialize your data structure here. */
        public MinStack() {
            dummyHead = new Node(0);
        }

        public void push(int x) {
            Node newNode = new Node(x);
            if (dummyHead.next != null) {
                if (newNode.minValue > getMin()) {
                    newNode.minValue = getMin();
                }
            }
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }

        public void pop() {
            Node delNode = dummyHead.next;
            dummyHead.next = delNode.next;
            delNode.next = null;
            delNode = null;
        }

        public int top() {
            return dummyHead.next.value;
        }

        public int getMin() {
            return dummyHead.next.minValue;
        }

        class Node {
            int value;
            Node next;
            int minValue;
            public Node(int value) {
                this.value = value;
                this.next = null;
                this.minValue = value;
            }
        }
    }
}
