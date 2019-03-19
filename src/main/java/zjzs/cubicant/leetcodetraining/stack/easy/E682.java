package zjzs.cubicant.leetcodetraining.stack.easy;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class E682 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new String[]{"5","2","C","D","+"});
        LeetCodeUtil.execute((Object) new String[]{"5","-2","4","C","D","9","+","+"});
    }

    class Solution {
        public int calPoints(String[] ops) {
            LinkedList<Integer> stack = new LinkedList<>();

            int num, temp;
            for (String op : ops) {
                switch (op) {
                    case "+":
                        temp = stack.pop();
                        num = temp + stack.peek();
                        stack.push(temp);
                        stack.push(num);
                        break;
                    case "D":
                        stack.push(stack.peek() * 2);
                        break;
                    case "C":
                        stack.pop();
                        break;
                    default:
                        stack.push(Integer.valueOf(op));
                        break;
                }
            }

            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }

            return result;
        }
    }
}
