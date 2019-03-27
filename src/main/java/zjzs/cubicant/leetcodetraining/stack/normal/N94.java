package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;
import zjzs.cubicant.leetcodetraining.util.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class N94 {
    public static void main(String[] args) {
        LeetCodeUtil.executeWithTree(new Integer[]{1, null, 2, 3});
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();

            if (root == null) {
                return result;
            }

            boolean leftVisited = false;
            TreeNode top;
            stack.push(root);
            while (!stack.isEmpty()) {
                top = stack.peek();
                if (top.left == null || leftVisited) {
                    result.add(top.val);
                    stack.pop();
                    if (top.right == null) {
                        leftVisited = true;
                    } else {
                        stack.push(top.right);
                        leftVisited = false;
                    }
                } else {
                    stack.push(top.left);
                    leftVisited = false;
                }
            }
            return result;
        }
    }
}
