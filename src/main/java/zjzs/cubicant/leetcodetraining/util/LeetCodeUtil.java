package zjzs.cubicant.leetcodetraining.util;

import zjzs.cubicant.leetcodetraining.util.model.ListNode;
import zjzs.cubicant.leetcodetraining.util.model.TreeNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * invoke the public method of innerClass Solution
 */
public class LeetCodeUtil {
    public static void execute(Object... args) {
        //1.get the className who is in the bottom of the stack
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String className = stackTraceElements[stackTraceElements.length - 1].getClassName();

        try {
            //2.reflect the outClass object
            Class<?> outerClass = Class.forName(className);
            Object outClassObject = outerClass.newInstance();

            //3.reflect the innerClass object
            //outerClass$innerClass
            Class<?> innerClass = Class.forName(className + "$Solution");
            //innerClass constructor -> innerClass(OutClass outClass)
            Constructor<?> innerClassConstructor = innerClass.getDeclaredConstructor(outerClass);
            //different package can't access
            innerClassConstructor.setAccessible(true);
            Object innerClassObject = innerClassConstructor.newInstance(outClassObject);

            //4.invoke the public method
            Method method = innerClass.getMethods()[0];
            method.setAccessible(true);
            Object result = method.invoke(innerClassObject, args);

            //5.output the result
            if (result.getClass().isArray()) {
                if (result instanceof long[]) {
                    result = Arrays.toString((long[]) result);
                } else if (result instanceof int[]) {
                    result = Arrays.toString((int[]) result);
                } else if (result instanceof short[]) {
                    result = Arrays.toString((short[]) result);
                } else if (result instanceof char[]) {
                    result = Arrays.toString((char[]) result);
                } else if (result instanceof byte[]) {
                    result = Arrays.toString((byte[]) result);
                } else if (result instanceof boolean[]) {
                    result = Arrays.toString((boolean[]) result);
                } else if (result instanceof float[]) {
                    result = Arrays.toString((float[]) result);
                } else if (result instanceof double[]) {
                    result = Arrays.toString((double[]) result);
                }
            }
            System.out.println(result);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void executeWithTree(Integer[] treeValList) {
        execute(createTree(treeValList));
    }

    public static void executeWithList(Integer[] valList) {
        execute(createList(valList));
    }

    //amend createTree method, now suits every case even if null is ignored
    public static TreeNode createTree(Integer[] treeValList) {
        if (treeValList == null || treeValList.length == 0 || treeValList[0] == null) {
            return null;
        }

        TreeNode[] tree = new TreeNode[treeValList.length];
        tree[0] = new TreeNode(treeValList[0]);
        boolean isLeft = true;
        int index;

        for (int i = 1; i < treeValList.length; ++i) {
            tree[i] = treeValList[i] == null ? null : new TreeNode(treeValList[i]);
            index = i;
            while (tree[index / 2 - (isLeft ? 0 : 1)] == null) {
                index += 2;
            }
            if (isLeft) {
                tree[index / 2].left = tree[i];
            } else {
                tree[index / 2 - 1].right = tree[i];
            }
            isLeft = !isLeft;
        }

        return tree[0];
    }

    public static ListNode createList(Integer[] valList) {
        if (valList == null || valList.length == 0) {
            return null;
        }

        ListNode head = new ListNode(valList[0]);
        ListNode cur = head;
        for (int i = 1; i < valList.length; ++i) {
            cur.next = new ListNode(valList[i]);
            cur = cur.next;
        }

        return head;
    }
}
