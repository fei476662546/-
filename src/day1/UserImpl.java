package day1;

public class UserImpl implements User{
    public String name;
    public int id;

    public UserImpl() {
    }

    public UserImpl(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void add(User user) {
        System.out.println("用户添加完成");
    }

    @Override
    public void delete(int id) {
        System.out.println("用户删除完成");

    }
}
