package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N1124 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new int[]{9,9,6,0,6,6,9});
        LeetCodeUtil.execute((Object) new int[]{6,9,9});
    }
    class Solution {
        public int longestWPI(int[] hours) {

            int len = hours.length;
            int[] preSums = new int[len + 1];
            preSums[0] = 0;
            for (int i = 1; i <= len; ++i) {
                preSums[i] = preSums[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            }

            // stack stores index & index starts with 0
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i <= len; ++i) {
                if (stack.isEmpty() || preSums[i] < preSums[stack.peek()]) {
                    stack.push(i);
                }
            }

            // use i > res optimize
            int res = 0;
            for (int i = len; i > res; --i) {
                while (!stack.isEmpty() && preSums[stack.peek()] < preSums[i]) {
                    res = Math.max(res, i - stack.pop());
                }
            }

            return res;

        }
    }
}
