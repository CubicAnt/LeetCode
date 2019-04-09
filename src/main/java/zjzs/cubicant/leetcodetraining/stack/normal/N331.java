package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N331 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("#");
        LeetCodeUtil.execute("#,#");
        LeetCodeUtil.execute("#,4");
        LeetCodeUtil.execute("#,#,#");
        LeetCodeUtil.execute("9,3,4,#,#,1,#,#,2,#,6,#,#");
        LeetCodeUtil.execute("1,#");
        LeetCodeUtil.execute("9,#,#,1");
        LeetCodeUtil.execute("9,3,4,#,#,1,#,#,#,2,#,6,#,#");
    }

    class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] splits = preorder.split(",");
            LinkedList<Node> stack = new LinkedList<>();
            Node top;

            if (splits.length == 1 && "#".equals(splits[0])) {
                return true;
            }

            for (int i = 0; i < splits.length; ++i) {
                switch (splits[i]) {
                    case "#":
                        if (stack.isEmpty()) {
                            return false;
                        }

                        while (!stack.isEmpty()) {
                            top = stack.peek();
                            if (top.leftVisited) {
                                stack.pop();
                            } else {
                                top.leftVisited = true;
                                break;
                            }
                        }

                        //test case: stack is empty but string is not at end after pop
                        if (stack.isEmpty() && i < splits.length - 1) {
                            return false;
                        }
                        break;
                    default:
                        stack.push(new Node(splits[i]));
                        break;
                }
            }

            return stack.isEmpty();
        }

        private class Node {
            String value;
            boolean leftVisited;

            Node(String value) {
                this.value = value;
                this.leftVisited = false;
            }
        }
    }
}
