package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N735 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new int[]{5, 10, -5});
        LeetCodeUtil.execute((Object) new int[]{8, -8});
        LeetCodeUtil.execute((Object) new int[]{10, 2, -5});
        LeetCodeUtil.execute((Object) new int[]{-2, -1, 1, 2});
    }

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < asteroids.length; ++i) {
                if (asteroids[i] > 0) {
                    stack.push(asteroids[i]);
                } else {
                    while (true) {
                        if (stack.isEmpty() || stack.peek() < 0) {
                            stack.push(asteroids[i]);
                            break;
                        } else {
                            if (asteroids[i] + stack.peek() == 0) {
                                stack.pop();
                                break;
                            } else if (asteroids[i] + stack.peek() < 0) {
                                stack.pop();
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; --i) {
                result[i] = stack.pop();
            }
            return result;
        }
    }
}
