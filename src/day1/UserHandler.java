package day1;

import java.awt.*;
import java.util.ArrayList;

/**
 * Create by mysteriousTime
 * time on 2019/6/27  16:29
 */
public abstract class UserHandler implements User {
    public abstract int add(User user);
    public abstract int delete(int id);
}
