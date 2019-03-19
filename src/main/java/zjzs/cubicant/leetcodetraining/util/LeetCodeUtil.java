package zjzs.cubicant.leetcodetraining.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
            Class<?> innerClass = Class.forName(className+"$Solution");
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
            System.out.println(result);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
