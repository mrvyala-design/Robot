package l2.reflection_task70;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Man {

    public String name;
    public int age;
    private double money;

    public Man(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void printMoney() {
        System.out.println(money);
    }

    public void printClassInfo() {
        Class clazz = Man.class;
        System.out.println("Поля класса:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("\nКонструкторы класса:");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("\nМетоды класса:");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
