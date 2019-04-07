package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N150 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new String[]{"2", "1", "+", "3", "*"});
        LeetCodeUtil.execute((Object) new String[]{"4", "13", "5", "/", "+"});
        LeetCodeUtil.execute((Object) new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            LinkedList<Integer> stack = new LinkedList<>();
            int number;
            for (String s : tokens) {
                switch (s) {
                    case "+":
                        number = stack.pop();
                        stack.push(stack.pop() + number);
                        break;
                    case "-":
                        number = stack.pop();
                        stack.push(stack.pop() - number);
                        break;
                    case "*":
                        number = stack.pop();
                        stack.push(stack.pop() * number);
                        break;
                    case "/":
                        number = stack.pop();
                        stack.push(stack.pop() / number);
                        break;
                    default:
                        stack.push(Integer.parseInt(s));
                        break;
                }
            }

            return stack.pop();
        }
    }
}
