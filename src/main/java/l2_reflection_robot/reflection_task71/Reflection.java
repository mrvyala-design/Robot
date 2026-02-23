package l2_reflection_robot.reflection_task71;

import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Printer printer = new Printer();
        Class clazz = printer.getClass();
        clazz.getMethod("printHelloWorld").invoke(printer);
    }
}