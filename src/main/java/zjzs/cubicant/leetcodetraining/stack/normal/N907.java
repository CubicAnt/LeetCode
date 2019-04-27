package zjzs.cubicant.leetcodetraining.stack.normal;

import zjzs.cubicant.leetcodetraining.util.LeetCodeUtil;

import java.util.LinkedList;

public class N907 {
    public static void main(String[] args) {
        LeetCodeUtil.execute((Object) new int[]{3,1,2,4});
    }

    class Solution {
        public int sumSubarrayMins(int[] A) {
            LinkedList<Node> stack = new LinkedList<>();
            int result = 0;
            int mod = 1000000007;
            int sum;
            int coef;
            Node top;

            result += A[0];
            stack.push(new Node(A[0], 1, A[0]));
            for (int i = 1; i < A.length; ++i) {
                sum = A[i];
                coef = 1;
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(new Node(A[i], coef, sum));
                        break;
                    }

                    top = stack.peek();
                    if (A[i] >= top.num) {
                        sum = (top.sum + sum) % mod;
                        stack.push(new Node(A[i], coef, sum));
                        break;
                    } else {
                        sum = (A[i] * top.coef + sum) % mod;
                        ++coef;
                        stack.pop();
                    }
                }

                result = (result + sum) % mod;
            }

            return result;
        }

        private class Node {
            int num;
            int coef;
            int sum;
            public Node(int num, int coef, int sum) {
                this.num = num;
                this.coef = coef;
                this.sum = sum;
            }
        }
    }
}
