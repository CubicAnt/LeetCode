package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class N946 {
    public static void main(String[] args) {
        LeetCodeUtil.execute(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
        LeetCodeUtil.execute(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2});
    }

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            LinkedList<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            Integer appearCnt;
            for (int i = 0; i < pushed.length; ++i) {
                appearCnt = map.get(pushed[i]);
                if (appearCnt == null) {
                    map.put(pushed[i], 1);
                } else {
                    map.put(pushed[i], appearCnt + 1);
                }
            }

            int j, splitIndex = 0;
            boolean popSuccess;
            for (int i = 0; i < popped.length; ++i) {
                if (map.get(popped[i]) != null) {
                    for (j = splitIndex; j < pushed.length; ++j) {
                        appearCnt = map.get(pushed[j]);
                        if (appearCnt > 1) {
                            map.put(pushed[j], appearCnt - 1);
                        } else {
                            map.remove(pushed[j]);
                        }
                        if (pushed[j] == popped[i]) {
                            splitIndex = j + 1;
                            break;
                        }
                        stack.push(pushed[j]);
                    }
                } else {
                    popSuccess = false;
                    while (!stack.isEmpty()) {
                        if (stack.pop() == popped[i]) {
                            popSuccess = true;
                            break;
                        }
                    }
                    if (!popSuccess) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
