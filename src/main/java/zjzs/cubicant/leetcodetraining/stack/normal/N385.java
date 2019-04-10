package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N385 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("[[],[]]");
        LeetCodeUtil.execute("[[]]");
        LeetCodeUtil.execute("324");
        LeetCodeUtil.execute("[324]");
        LeetCodeUtil.execute("[123,[456,[789]]]");
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        private Object object;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            object = new ArrayList<NestedInteger>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            object = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return (object instanceof Integer);
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return (Integer) object;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            object = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            ((List<NestedInteger>) object).add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) object;
        }
    }

    class Solution {
        public NestedInteger deserialize(String s) {
            LinkedList<NestedInteger> stack = new LinkedList<>();
            StringBuilder numberStr = new StringBuilder();
            NestedInteger top;

            for (char c : s.toCharArray()) {
                switch (c) {
                    case '[':
                        stack.push(new NestedInteger());
                        break;
                    case ',':
                        if (numberStr.length() > 0) {
                            stack.peek().add(new NestedInteger(Integer.parseInt(numberStr.toString())));
                            numberStr = new StringBuilder();
                        }
                        break;
                    case ']':
                        if (numberStr.length() > 0) {
                            stack.peek().add(new NestedInteger(Integer.parseInt(numberStr.toString())));
                            numberStr = new StringBuilder();
                        }

                        top = stack.pop();
                        if (stack.isEmpty()) {
                            return top;
                        } else {
                            stack.peek().add(top);
                        }
                        break;
                    default:
                        numberStr.append(c);
                        break;
                }
            }

            if (numberStr.length() > 0) {
                return new NestedInteger(Integer.parseInt(numberStr.toString()));
            } else {
                return stack.peek();
            }
        }
    }
}
