package com.yiming.tank;

import java.awt.image.BufferedImage;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 17:46
 */
public class GoodStyle1Factory extends AbstractStyleFactory {

    @Override
    void tankStyle() {
        new GoodTankStyle1();
    }

    @Override
    void bulletStyle() {
        new GoodBulletStyle1();
    }

    @Override
    void ExplodeStyle() {

    }
}
