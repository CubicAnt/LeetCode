package zjzs.cubicant.leetcodetraining.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * invoke the public method of innerClass Solution
 */
public class LeetCodeUtil {
    public static void execute(Object... args) {
        //1.get the className who invoke this method
        String className = Thread.currentThread().getStackTrace()[2].getClassName();

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
}
