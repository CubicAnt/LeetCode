package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

public class N503 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new int[]{1,2,1});
    }

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int length = nums.length;
            int j = length - 1;

            int[] result = new int[length];
            int[] next = new int[length];

            if (length == 0) { //avoid j OutOfArrayBounds
                return result;
            }

            for (int i = 0; i < length - 1; ++i) {
                if (nums[i] > nums[j]) {
                    result[j] = nums[i];
                    next[j] = i;
                    j = i;
                }
            }
            result[j] = -1;
            next[j] = -1;

            int k;
            for (int i = length - 2; i >= 0; --i) {
                if (nums[i] < nums[i + 1]) {
                    result[i] = nums[i + 1];
                    next[i] = i + 1;
                } else {
                    k = i + 1;
                    while (true) {
                        if (next[k] == -1) {
                            result[i] = -1;
                            next[i] = -1;
                            break;
                        } else if (nums[i] < nums[next[k]]) {
                            result[i] = nums[next[k]];
                            next[i] = next[k];
                            break;
                        } else {
                            k = next[k];
                        }
                    }
                }
            }

            return result;
        }
    }
}
