package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;
import zjzs.cubicant.leetcodetraining.util.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class N144 {
    public static void main(String[] args) {
        LeetCodeUtil.executeWithTree(new Integer[]{1, null, 2, 3});
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode top;
            stack.push(root);
            while (!stack.isEmpty()) {
                top = stack.pop();
                result.add(top.val);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
            return result;
        }
    }
}
