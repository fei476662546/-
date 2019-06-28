package com.ecjtu.dao.impl;

import com.ecjtu.dao.IGetName;

public class A  implements IGetName {
    @Override
    public void getName() {
        System.out.println("A程序员实现的方法");
    }
}
