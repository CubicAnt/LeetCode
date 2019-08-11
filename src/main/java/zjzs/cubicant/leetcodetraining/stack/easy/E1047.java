package zjzs.cubicant.leetcodetraining.stack.easy;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class E1047 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("abbaca");
    }

    class Solution {
        public String removeDuplicates(String S) {

            LinkedList<Character> stack = new LinkedList<>();

            for (char c : S.toCharArray()) {
                if (stack.isEmpty() || c != stack.peek()) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }

            StringBuilder res = new StringBuilder();

            while(!stack.isEmpty()) {
                res.insert(0, stack.pop());
            }

            return res.toString();

        }
    }
}
