package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;
import zjzs.cubicant.leetcodetraining.util.model.ListNode;

import java.util.LinkedList;

public class N1019 {
    public static void main(String[] args) {
        LeetCodeUtil.executeWithList(new Integer[]{});
        LeetCodeUtil.executeWithList(new Integer[]{2,1,5});
        LeetCodeUtil.executeWithList(new Integer[]{2,7,4,3,5});
        LeetCodeUtil.executeWithList(new Integer[]{1,7,5,1,9,2,5,1});
    }
    class Solution {

        public int[] nextLargerNodes(ListNode head) {
            int[] temp = new int[10000];
            int index = 0;
            LinkedList<Node> stack = new LinkedList<>();
            Node top;
            ListNode cur = head;

            while (cur != null) {
                if (stack.isEmpty()) {
                    stack.push(new Node(cur.val, index++));
                    cur = cur.next;
                }

                if (cur == null) {
                    break;
                }

                top = stack.peek();
                if (top.val < cur.val) {
                    temp[top.index] = cur.val;
                    stack.pop();
                } else {
                    stack.push(new Node(cur.val, index++));
                    cur = cur.next;
                }
            }

            while (!stack.isEmpty()) {
                temp[stack.pop().index] = 0;
            }

            int[] result = new int[index];
            for (int i = 0; i < index; ++i) {
                result[i] = temp[i];
            }

            return result;
        }

        private class Node {
            int val;
            int index;

            Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }
    }
}
