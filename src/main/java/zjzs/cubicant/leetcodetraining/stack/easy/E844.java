package zjzs.cubicant.leetcodetraining.stack.easy;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class E844 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("ab#c", "ad#c");
        LeetCodeUtil.execute("ab##", "c#d#");
        LeetCodeUtil.execute("a##c", "#a#c");
        LeetCodeUtil.execute("a#c", "b");
    }

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            LinkedList<Character> sStack = new LinkedList<>();
            LinkedList<Character> tStack = new LinkedList<>();
            for (char c : S.toCharArray()) {
                if (c == '#') {
                    if (!sStack.isEmpty()) {
                        sStack.pop();
                    }
                } else {
                    sStack.push(c);
                }
            }
            for (char c : T.toCharArray()) {
                if (c == '#') {
                    if (!tStack.isEmpty()) {
                        tStack.pop();
                    }
                } else {
                    tStack.push(c);
                }
            }

            while (!sStack.isEmpty() && !tStack.isEmpty()) {
                if (sStack.pop() != tStack.pop()) {
                    return false;
                }
            }
            return sStack.isEmpty() && tStack.isEmpty();
        }
    }
}
