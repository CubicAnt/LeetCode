package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N921 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("())");
        LeetCodeUtil.execute("(((");
        LeetCodeUtil.execute("()");
        LeetCodeUtil.execute("()))((");
    }

    class Solution {
        public int minAddToMakeValid(String S) {
            if (S == null || S.length() == 0) {
                return 0;
            }

            LinkedList<Character> stack = new LinkedList<>();
            int addSum = 0, leftSum = 0;
            for (char c : S.toCharArray()) {
                if (c == '(') {
                    ++leftSum;
                }
                stack.push(c);
            }

            while (!stack.isEmpty()) {
                switch (stack.pop()) {
                    case '(':
                        --leftSum;
                        ++addSum;
                        break;
                    case ')':
                        if (leftSum > 0) {
                            --leftSum;
                            --addSum;
                        } else {
                            ++addSum;
                        }
                        break;
                }
            }

            return addSum;
        }
    }
}
