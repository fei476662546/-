package test;

import sun.reflect.misc.ConstructorUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create by mysteriousTime
 * time on 2019/6/27  11:22
 */
public class ReflectConstructor {
    Student student=new Student();
        Class<?> cls;

    {
        try {
            cls = Class.forName(student.getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //参数类型
        Class<?>[] params = {String.class, String.class, Integer.TYPE};
        //参数值
        Object[] values = {"阿球", "男", 21};
        //构造三个参数的构造函数；
        Constructor<?> constructor;

    {
        try {
            constructor = cls.getDeclaredConstructor(params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    //根据构造函数，传入值生成实例
        Object object;

    {
        try {
            object = constructor.newInstance(values);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    Method getName;
    {
        try {
            getName = cls.getDeclaredMethod("getName", params);
            try {
                System.out.println("getName ="+(String) getName.invoke(object, "getName"));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    Method getSex;
    {
        try {
            getSex = cls.getDeclaredMethod("getSex", params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    Method getAge;
    {
        try {
            getAge = cls.getDeclaredMethod("getAge", params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


}
