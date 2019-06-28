package test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Create by mysteriousTime
 * time on 2019/6/27  15:08
 */
public class test2 {
    public static void printClassMessage(Object obj){
        //要获取的信息，首先要获取类的类类型
        Class c=obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
        //获取类的名称
        System.out.println("类的名称是："+c.getName());
        /**
         * Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethod()方法获取的是所有Public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
         */
        Method[] ms=c.getMethods();//c.getDeclaredMethods()
        for (int i=0;i<ms.length;i++){
            //得到方法的返回值类型的类型
            Class returnType=ms[i].getReturnType();
            System.out.println(returnType.getName());
            //得到方法的名称
            System.out.println(ms[i].getName());
            //获取参数类型-->得到的是参数列表的类型的类类型
            Class[]paramTypes=ms[i].getParameterTypes();
            for (Class class1:paramTypes){
                System.out.print(class1.getName()+",");
            }
        }
        /*getFields()方法获取的是所有Public的函数，包括父类继承而来的
         * getDeclaredFields()获取的是所有该类自己声明的方法，不问访问权限
        *
        * */
        Field[] fs=c.getDeclaredFields();
        for (Field field:fs){
            //得到成员变量的类型的类类型
            Class fieldType=field.getType();
            String typeName=field.getName();
            //得到成员变量的名称
            String fieldName=field.getName();
            System.out.println(typeName+" "+fieldName);
        }
    }
}
class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print(String a,String b){
        System.out.println(a.toUpperCase()+b.toLowerCase());
    }
}
class MethodDemlo{
    public static void main(String[] args) {
        //要获取print（int,int）方法 1，要获取方法就是要获取类的信息，要获取类的信息首先要获取类的类类型
   A a1=new A();
   Class c=a1.getClass();
        /**
         * 2,获取方法  名称和参数列表的决定
         * getMethod获取的是public的方法
         */
        try {
       //Method m=c.getMethods("print", new Class[]{int.class, int.class});
           Method m=c.getMethod("print",int.class,int.class);
           //方法的反射操作
            // a1.print(10,20);方法的放射是用m对象来进行方法调用和a1.print调用的效果完全相同
            //方法如果没有返回值返回null，有就返回返回值
     Object ob=  m.invoke(a1,new Object[]{10,20});
     Object ob1=m.invoke(a1,10,20);
            System.out.println("=============================");
            Method m1=c.getMethod("print", String.class,String.class);
            m1.invoke(a1,"hello","world");
            m1.invoke(a1,new Object[]{"你","好0"});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}