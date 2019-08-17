package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.HashMap;
import java.util.Map;

public class N880 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("leet2code3", 10);
        LeetCodeUtil.execute("ha22", 5);
        LeetCodeUtil.execute("a2345678999999999999999", 1);
    }

    class Solution {
        public String decodeAtIndex(String S, int K) {
            char[] sArray = S.toCharArray();
            Map<Long, Character> map = new HashMap<>();
            long ind = K;
            long len, lastLen;
            boolean isFirst = true;

            while (true) {
                len = 0L;
                lastLen = 0L;
                for (int i = 0; ;++i) {
                    if (sArray[i] >= 'a' && sArray[i] <= 'z') {
                        ++len;
                        if (isFirst) {
                            map.put(len, sArray[i]);
                        }
                    } else {
                        len *= (sArray[i] - '0');
                        if (isFirst) {
                            map.put(len, map.get(lastLen));
                        }
                    }

                    // check len before forward lastLen
                    if (len >= ind) {
                        break;
                    }
                    lastLen = len;
                }

                if (len == ind) {
                    return "" + map.get(len);
                }

                ind = (ind - lastLen) % lastLen;
                if (ind == 0) {
                    return "" + map.get(lastLen);
                }

                isFirst = false;
            }
        }
    }
}
