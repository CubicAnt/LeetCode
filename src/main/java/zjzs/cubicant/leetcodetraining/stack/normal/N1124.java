package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

public class N1124 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new int[]{9,9,6,0,6,6,9});
    }
    class Solution {
        public int longestWPI(int[] hours) {
            int curLen = 0, maxLen = 0, sum = 0;
            for (int x: hours) {
                sum += (x > 8 ? 1 : -1);
                if (sum < 0) {
                    sum = 0;
                } else if (sum == 0) {
                    maxLen = Math.max(maxLen, curLen);
                    curLen = 0;
                } else {
                    ++curLen;
                }
            }
            return Math.max(maxLen, curLen);
        }
    }
}
