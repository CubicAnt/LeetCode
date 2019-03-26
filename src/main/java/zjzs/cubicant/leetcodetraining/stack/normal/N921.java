package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N921 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("())");
        LeetCodeUtil.execute("(((");
        LeetCodeUtil.execute("()");
        LeetCodeUtil.execute("()))((");
        LeetCodeUtil.execute("()()");
    }

    class Solution {
        public int minAddToMakeValid(String S) {
            if (S == null || S.length() == 0) {
                return 0;
            }

            LinkedList<Character> stack = new LinkedList<>();
            //add storedLeft to avoid repeat minus leftSum in such case "()()"
            int addSum = 0, leftSum = 0, storedLeft = 0;
            for (char c : S.toCharArray()) {
                if (c == '(') {
                    ++leftSum;
                }
                stack.push(c);
            }

            while (!stack.isEmpty()) {
                switch (stack.pop()) {
                    case '(':
                        if (storedLeft > 0) {
                            --storedLeft;
                        } else {
                            --leftSum;
                        }
                        ++addSum;
                        break;
                    case ')':
                        if (leftSum > 0) {
                            --leftSum;
                            ++storedLeft;
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
