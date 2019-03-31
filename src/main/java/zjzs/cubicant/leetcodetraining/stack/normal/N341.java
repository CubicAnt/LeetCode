package zjzs.cubicant.leetcodetraining.stack.normal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class N341 {
     public interface NestedInteger {
         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();

         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
     }

    public class NestedIterator implements Iterator<Integer> {
        private LinkedList<NestedIntegerWrap> stack = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList != null && nestedList.size() > 0) {
                stack.push(new NestedIntegerWrap(nestedList));
            }
        }

        @Override
        public Integer next() {
            NestedIntegerWrap top;
            NestedInteger val;
            List<NestedInteger> nestedList;
            while (!stack.isEmpty()) {
                top = stack.peek();
                if (!top.hasNext()) {
                    stack.pop();
                }
                val = top.getNestedInteger();
                if (val.isInteger()) {
                    return val.getInteger();
                } else {
                    nestedList = val.getList();
                    if (nestedList != null && nestedList.size() > 0) {
                        stack.push(new NestedIntegerWrap(nestedList));
                    }
                }
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        class NestedIntegerWrap {
            List<NestedInteger> nestedList;
            int index;

            NestedIntegerWrap(List<NestedInteger> nestedList) {
                this.nestedList = nestedList;
            }

            boolean hasNext() {
                return index < nestedList.size() - 1;
            }

            NestedInteger getNestedInteger() {
                return nestedList.get(index++);
            }
        }
    }
}
