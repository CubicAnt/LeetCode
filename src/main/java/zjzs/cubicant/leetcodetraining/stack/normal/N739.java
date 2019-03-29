package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

public class N739 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] result = new int[T.length];
            result[T.length - 1] = 0;
            int[] next = new int[T.length];
            next[T.length - 1] = -1;
            int index;
            for (int i = T.length - 2; i >= 0; --i) {
                if (T[i] < T[i + 1]) {
                    result[i] = 1;
                    next[i] = i + 1;
                } else {
                    index = next[i + 1];
                    while (true) {
                        if (index == -1) {
                            result[i] = 0;
                            next[i] = -1;
                            break;
                        } else if (T[i] < T[index]) {
                            result[i] = index - i;
                            next[i] = index;
                            break;
                        } else {
                            index = next[index];
                        }
                    }
                }
            }
            return result;
        }
    }
}
