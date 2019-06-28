package day1;

public class Student {
    private String name;
    private int age=18;
    private String sex;

    public Student() {
        System.out.println("这是无参构造函数");
    }
    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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


    public String show() {
        return "Student{" + "name='" + name  + ", age=" + age + ", sex='" + sex+"}";
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
