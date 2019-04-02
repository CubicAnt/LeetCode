package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N1003 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("aabcbc");
        LeetCodeUtil.execute("abcabcababcc");
        LeetCodeUtil.execute("abccba");
        LeetCodeUtil.execute("cababc");
    }

    class Solution {
        public boolean isValid(String S) {
            LinkedList<Character> stack = new LinkedList<>();
            for (char c : S.toCharArray()) {
                switch (c) {
                    case 'a':
                        stack.push(c);
                        break;
                    case 'b':
                        if (stack.isEmpty() || stack.peek() == 'b') {
                            return false;
                        }
                        stack.pop();
                        stack.push(c);
                        break;
                    case 'c':
                        if (stack.isEmpty() || stack.peek() == 'a') {
                            return false;
                        }
                        stack.pop();
                        break;
                }
            }

            return stack.isEmpty();
        }
    }
}
