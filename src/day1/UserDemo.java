package day1;

public class UserDemo {
    public static void main(String[] args) {
        User user =(User) new LinkUser().getInstance(new UserImpl());
        user.add(new UserImpl("张飞",22));
        user.delete(22);
    }
}
