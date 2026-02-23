package l2_reflection_robot.reflection_task72;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class Program {
    public static void main(String[] args) {

        MyAnnotation annotation = new MyAnnotation();
        Class clazz = annotation.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Annotation anno = method.getAnnotation(MyAnnotation.academyinfo.class);
            if (anno == null) {
                System.out.println("Метод " + method.getName() + " не содержит аннотации.");
            } else {
                System.out.println("Метод " + method.getName() + " содержит аннотацию.");
            }
        }
    }
}