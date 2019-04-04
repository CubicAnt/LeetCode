package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;
import zjzs.cubicant.leetcodetraining.util.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class N103 {
    public static void main(String[] args) {
        LeetCodeUtil.executeWithTree(new Integer[]{3,9,20,null,null,15,7});
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.push(root);
            TreeNode top;
            boolean isEven = false;
            int size;
            while (!queue.isEmpty()) {
                List<Integer> levelList = new LinkedList<>();
                size = queue.size();
                for (int i = 0; i < size; ++i) {
                    top = queue.poll();
                    if (isEven) {
                        levelList.add(0, top.val);
                    } else {
                        levelList.add(top.val);
                    }
                    if (top.left != null) {
                        queue.offer(top.left);
                    }
                    if (top.right != null) {
                        queue.offer(top.right);
                    }
                }
                result.add(levelList);
                isEven = !isEven;
            }

            return result;
        }
    }
}
