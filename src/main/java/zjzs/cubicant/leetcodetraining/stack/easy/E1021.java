package zjzs.cubicant.leetcodetraining.stack.easy;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.Arrays;
import java.util.LinkedList;

public class E1021 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("(()())(())");
        LeetCodeUtil.execute("(()())(())(()(()))");
        LeetCodeUtil.execute("()()");
    }

    class Solution {
        public String removeOuterParentheses(String S) {
            if (S == null || S.length() == 0) {
                return "";
            }

            LinkedList<Integer> stack = new LinkedList<>();
            boolean[] remains = new boolean[S.length()];
            int top;
            StringBuilder result = new StringBuilder();

            Arrays.fill(remains, true);
            stack.push(0);
            remains[0] = false;
            for (int i = 1; i < S.length(); ++i) {
                switch (S.charAt(i)) {
                    case '(':
                        stack.push(i);
                        break;
                    case ')':
                        top = stack.pop();
                        if (stack.size() == 0) {
                            remains[i] = false;
                            remains[top] = false;
                        }
                        break;
                }
            }

            for (int i = 0; i < S.length(); ++i) {
                if (remains[i]) {
                    result.append(S.charAt(i));
                }
            }

            return result.toString();
        }

    }
}
