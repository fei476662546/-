package com.ecjtu.test;

import com.ecjtu.dao.IGetName;
import com.ecjtu.factory.Factory;
import org.junit.Test;

public class TestFactory {

    @Test
    public void getInstance(){
        Factory factory=Factory.getInstance();
        IGetName getName = factory.getName();
        getName.getName();
    }
}
