package day1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class cla=Class.forName("com.ecjtu.day21.Practice.Student");
        //无参构造函数
        Student student=(Student) cla.newInstance();
        //有参构造函数
        Constructor[] constructor=cla.getConstructors();
        Constructor constructor1 =cla.getConstructor(String.class,String.class);
        Constructor constructor2 =cla.getConstructor(String.class,int.class,String.class);
        Student student1=(Student) constructor1.newInstance("张三","男");
        Student student2=(Student) constructor2.newInstance("李四",23,"男");
        System.out.println(student.show());
        System.out.println(student1.show());
        System.out.println(student2.show());
        //访问全局属性
        Field field=cla.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println(field.get(student1));
        field.set(student1,34);
        System.out.println(student1.show());
        //访问方法
        Method method =cla.getMethod("show",null);
        System.out.println(method.invoke(student2, null));
        //越过范式检查
        ArrayList<String> list= new ArrayList<>();
        list.add("王朝");
        list.add("马汉");
        Class clazz=list.getClass();
        Method m=clazz.getDeclaredMethod("add",Object.class);
        m.setAccessible(true);
        m.invoke(list,student2);
        for (Object o:list) {
            System.out.println(o);
        }
    }
}
