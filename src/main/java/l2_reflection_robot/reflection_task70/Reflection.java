package l2_reflection_robot.reflection_task70;

import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Man man = new Man("Pavel", 25, 1234.56);
        Class clazz = man.getClass();
        clazz.getMethod("printClassInfo").invoke(man);
    }
}