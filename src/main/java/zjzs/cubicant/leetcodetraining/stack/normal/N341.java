package zjzs.cubicant.leetcodetraining.stack.normal;

import java.util.*;

public class N341 {
    public static void main(String[] args) {
        N341 n341 = new N341();
        List<NestedInteger> list = new ArrayList<>();
        list.add(n341.new NestedIntegerImpl(new ArrayList<NestedInteger>()));
        NestedIterator nestedIterator = n341.new NestedIterator(list);
        List<Integer> result = new ArrayList<>();
        while (nestedIterator.hasNext()) {
            result.add(nestedIterator.next());
        }
        System.out.println(result);
    }

    public class NestedIntegerImpl implements NestedInteger {
        private Object object;

        public NestedIntegerImpl(Object object) {
            this.object = object;
        }

        @Override
        public boolean isInteger() {
            return (object instanceof Integer);
        }

        @Override
        public Integer getInteger() {
            return (Integer) object;
        }

        @Override
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) object;
        }
    }

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
        //use pre-calculate nextVal avoid nested empty list case
        private Integer nextVal;

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList != null && nestedList.size() > 0) {
                stack.push(new NestedIntegerWrap(nestedList));
            }
            //first pre-calculate nextVal when new NestedIterator
            nextVal = getNext();
        }

        private Integer getNext() {
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

        //pre-calculate nextVal and return tempVal
        @Override
        public Integer next() {
            Integer tempVal = nextVal;
            nextVal = getNext();
            return tempVal;
        }

        //pre-calculate nextVal is null => hasNext is null
        @Override
        public boolean hasNext() {
            return nextVal != null;
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
