package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N636 {
    public static void main(String[] args) {
        LeetCodeUtil.execute(2, Arrays.asList("0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"));
    }

    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            LinkedList<MethodLog> stack = new LinkedList<>();
            int[] result = new int[n];
            Arrays.fill(result, 0);

            String[] log;
            int id;
            boolean isStart;
            int timeStamp;
            MethodLog top;
            int time;
            for (String s : logs) {
                log = s.split(":");
                id = Integer.parseInt(log[0]);
                isStart = "start".equals(log[1]);
                timeStamp = Integer.parseInt(log[2]);
                if (isStart) {
                    stack.push(new MethodLog(id, isStart, timeStamp));
                } else {
                    top = stack.pop();
                    time = timeStamp - top.timeStamp + 1;
                    result[top.id] += time;
                    if (!stack.isEmpty()) {
                        result[stack.peek().id] -= time;
                    }
                }
            }

            return result;
        }

        private class MethodLog {
            int id;
            boolean isStart;
            int timeStamp;

            MethodLog(int id, boolean isStart, int timeStamp) {
                this.id = id;
                this.isStart = isStart;
                this.timeStamp = timeStamp;
            }
        }
    }
}
