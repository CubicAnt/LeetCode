package zjzs.cubicant.leetcodetraining.stack.easy;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.HashMap;
import java.util.Map;

public class E496 {
    public static void main(String[] args) {
        LeetCodeUtil.execute(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        LeetCodeUtil.execute(new int[]{2, 4}, new int[]{1, 2, 3, 4});
    }

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];
            Map<Integer, Integer> map = new HashMap<>();

            if (nums2.length == 0) {
                return result;
            }
            map.put(nums2[nums2.length - 1], -1);

            int a, b, aplus = -1, bplus;
            boolean flag;
            for (int i = nums2.length - 2; i >= 0; i--) {
                a = nums2[i];
                b = nums2[i + 1];
                bplus = map.get(b);

                do {
                    flag = false; //move the flag into while block for modifying flag in each branch
                    if (a < b) {
                        aplus = b;
                    } else {
                        if (bplus == -1) {
                            aplus = -1;
                        } else if (a < bplus) {
                            aplus = bplus;
                        } else {
                            b = bplus;
                            flag = true;
                        }
                    }
                } while (flag);

                map.put(a, aplus);
            }

            for (int i = 0; i < nums1.length; ++i) {
                result[i] = map.get(nums1[i]);
            }
            return result;
        }
    }
}
