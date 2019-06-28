package test;
/**
 * Create by mysteriousTime
 * time on 2019/6/27  10:02
 */
public class factory {
    private static factory instance =new factory();

    private factory()
    {

    }
    public static factory getInstance(){
        return instance;
    }
}
