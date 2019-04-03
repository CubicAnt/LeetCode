package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N856 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("()");
        LeetCodeUtil.execute("(())");
        LeetCodeUtil.execute("()()");
        LeetCodeUtil.execute("(()(()))");
    }

    class Solution {
        public int scoreOfParentheses(String S) {
            LinkedList<Integer> stack = new LinkedList<>();
            int sum, top;
            for (char c : S.toCharArray()) {
                switch (c) {
                    case '(':
                        stack.push(-1);
                        break;
                    case ')':
                        top = stack.pop();
                        sum = 0;
                        while (top != -1) {
                            sum += top;
                            top = stack.pop();
                        }
                        if (sum > 0) {
                            stack.push(2 * sum);
                        } else {
                            stack.push(1);
                        }
                        break;
                }
            }

            sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            return sum;
        }
    }
}
