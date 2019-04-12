package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N71 {
    public static void main(String[] args) {
        LeetCodeUtil.execute("/home/");
        LeetCodeUtil.execute("/../");
        LeetCodeUtil.execute("/home//foo/");
        LeetCodeUtil.execute("/a/./b/../../c/");
        LeetCodeUtil.execute("/a/../../b/../c//.//");
        LeetCodeUtil.execute("/a//b////c/d//././/..");
        LeetCodeUtil.execute("");
        LeetCodeUtil.execute("home");
        LeetCodeUtil.execute("/");
        LeetCodeUtil.execute("///");
    }

    class Solution {
        public String simplifyPath(String path) {
            if (path == null || "".equals(path)) {
                return "/";
            }

            LinkedList<String> stack = new LinkedList<>();
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();

            stack.push("/");
            if ('/' != path.charAt(path.length() - 1)) {
                path = path + "/";
            }

            for (char c : path.toCharArray()) {
                switch (c) {
                    case '/':
                        switch (temp.toString()) {
                            case "":
                            case ".":
                                break;
                            case "..":
                                stack.pop();
                                if (stack.isEmpty()) {
                                    stack.push("/");
                                } else {
                                    stack.pop();
                                }
                                break;
                            default:
                                stack.push(temp.toString());
                                stack.push("/");
                                break;
                        }
                        temp = new StringBuilder();
                        break;
                    default:
                        temp.append(c);
                        break;
                }
            }

            while (!stack.isEmpty()) {
                result.insert(0, stack.pop());
            }

            if (result.length() > 1 && '/' == result.charAt(result.length() - 1)) {
                result.deleteCharAt(result.length() - 1);
            }

            return result.toString();
        }
    }
}
