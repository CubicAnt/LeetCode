package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

public class N456 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new int[]{1, 2, 3, 4});
        LeetCodeUtil.execute((Object) new int[]{3, 1, 4, 2});
        LeetCodeUtil.execute((Object) new int[]{-1, 3, 2, 0});
    }

    class Solution {
        public boolean find132pattern(int[] nums) {
            if (nums == null) {
                return false;
            }

            int len = nums.length;
            if (len < 3) {
                return false;
            }

            int[] Min = new int[len];
            int[] Rev = new int[len];
            Min[0] = 0;
            Rev[0] = -1;

            for (int i = 1, j = i - 1; i < len; ++i) {
                j = i - 1;
                while (j >= 0) {
                    if (nums[j] == nums[i]) {
                        Rev[i] = Rev[j];
                        break;
                    } else if (nums[j] > nums[i]) {
                        if (nums[i] > nums[Min[j]]) {
                            return true;
                        } else {
                            Rev[i] = j;
                            break;
                        }
                    } else {
                        j = Rev[j];
                    }
                }
                if (j < 0) {
                    Rev[i] = -1;
                }
                Min[i] = nums[i - 1] > nums[Min[i - 1]] ? Min[i - 1] : i - 1;
            }

            return false;
        }
    }
}
