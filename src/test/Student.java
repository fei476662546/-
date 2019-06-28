package test;

import sun.management.Agent;

import javax.naming.Name;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * Create by mysteriousTime
 * time on 2019/6/27  11:04
 * 1、有一个学生类 姓名，年龄，性别（属性私有），提供三个构造方法
 * 一个默认构造方法，一个给全部属性赋值的构造方法，一个提供执行的姓名和性别，
 * 年龄给默认值，一个show()方法，该方法显示学生的基本信息，
 * 1）请利用反射，构造student对象，
 */
public class Student {
    private String name;
    private int age;
    private String sex;
    public Student(){}
    public Student(String name,int age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    public  Student(String name,String sex){
        this.name=name;
        this.age= 20;
        this.sex=sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public void show(){
        System.out.println("学生姓名："+getName());
        System.out.println("学生年龄："+getAge());
        System.out.println("学生性别："+getSex());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
class TestStudent{
    public static void main(String[] args)throws ClassNotFoundException,InstantiationException,IllegalAccessException {
        Student student=new Student("一",20,"男");
        Class<?> cls = Class.forName("test.Student");//通过类全限定名获取Person的Class类对象
        Student s = (Student) cls.newInstance();// newInstance()实例化对象
        System.out.println(s);
        Constructor con= null;
        try {
            con = cls.getConstructor(new Class[] {String.class,String.class});
            try {
                Object obj=con.newInstance(new Object[]{"阿球","男"});
                System.out.println("修改前："+obj);
                // 调用getDeclaredField("name") 取得name属性对应的Field对象
                Field fie=cls.getDeclaredField("age");
                // 取消属性的访问权限控制，即使private属性也可以进行访问。
                fie.setAccessible(true);
                // 调用get()方法取得对应属性值。
                System.out.println(fie.get(obj));  //相当于obj.getAge();
                // 调用set()方法给对应属性赋值。
                fie.set(obj,30);  //相当于obj.setAge("30");
                // 调用get()方法取得对应属性修改后的值。
                System.out.println("修改后："+obj);
                Method men=cls.getDeclaredMethod("show");
                    men.invoke(student);
                ArrayList<String> list=new ArrayList();
                list.add(s.getName());
                list.add(student.getName());
                Class c=list.getClass();
                //绕过泛型进行反射
             Method method=c.getMethod("add",Object.class);
             method.invoke(list,1);
                System.out.println(list);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}