package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N394 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("3[a]2[bc]");
        LeetCodeUtil.execute("3[a2[c]]");
        LeetCodeUtil.execute("2[abc]3[cd]ef");
    }

    class Solution {
        public String decodeString(String s) {
            LinkedList<String> stack = new LinkedList<>();
            StringBuilder digitTemp = new StringBuilder();
            StringBuilder strTemp = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            String encodeStr;
            int encodeNumber;

            for (char c : s.toCharArray()) {
                switch (c) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        if (strTemp.length() > 0) {
                            stack.push(strTemp.toString());
                            strTemp = new StringBuilder();
                        }
                        digitTemp.append(c);
                        break;
                    case '[':
                        if (digitTemp.length() > 0) {
                            stack.push(digitTemp.toString());
                            digitTemp = new StringBuilder();
                        }
                        stack.push("[");
                        break;
                    case ']':
                        while (!"[".equals(stack.peek())) {
                            strTemp.insert(0 ,stack.pop());
                        }
                        stack.pop();
                        encodeStr = strTemp.toString();
                        strTemp = new StringBuilder();
                        encodeNumber = Integer.parseInt(stack.pop());
                        for (int i = 0; i < encodeNumber; ++i) {
                            temp.append(encodeStr);
                        }
                        stack.push(temp.toString());
                        temp = new StringBuilder();
                        break;
                    default:
                        strTemp.append(c);
                        break;
                }
            }

            if (digitTemp.length() > 0) {
                temp.append(digitTemp);
            }

            if (strTemp.length() > 0) {
                temp.append(strTemp);
            }

            while (!stack.isEmpty()) {
                temp.insert(0, stack.pop());
            }

            return temp.toString();
        }
    }
}
