package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;
import zjzs.cubicant.leetcodetraining.util.model.TreeNode;

import java.util.LinkedList;

public class N173 {
    public static void main(String[] args) {
        TreeNode root = LeetCodeUtil.createTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator iterator = new N173().new BSTIterator(root);
        System.out.println(iterator.next());    // 返回 3
        System.out.println(iterator.next());    // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false
    }

    class BSTIterator {
        private TreeNode mTop;
        private boolean mLeftVisited;
        private LinkedList<TreeNode> mStack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            if (root != null) {
                mStack.push(root);
            }
        }

        /** @return the next smallest number */
        public int next() {
            while (!mStack.isEmpty()) {
                mTop = mStack.peek();
                if (mTop.left == null || mLeftVisited) {
                    mStack.pop();
                    if (mTop.right == null) {
                        mLeftVisited = true;
                    } else {
                        mStack.push(mTop.right);
                        mLeftVisited = false;
                    }
                    break;
                } else {
                    mStack.push(mTop.left);
                    mLeftVisited = false;
                }
            }
            return mTop.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !mStack.isEmpty();
        }
    }
}
