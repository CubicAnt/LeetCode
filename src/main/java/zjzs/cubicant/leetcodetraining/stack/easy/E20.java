package zjzs.cubicant.leetcodetraining.stack.easy;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class E20 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("()");
        LeetCodeUtil.execute("()[]{}");
        LeetCodeUtil.execute("(]");
        LeetCodeUtil.execute("([)]");
        LeetCodeUtil.execute("{[]}");
    }

    class Solution {
        public boolean isValid(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (stack.isEmpty()) {
                            return false;
                        }
                        if (map.get(stack.peek()) != c) {
                            return false;
                        } else {
                            stack.pop();
                        }
                        break;
                }
            }
            return stack.isEmpty();
        }
    }
}
