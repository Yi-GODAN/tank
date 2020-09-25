package com.yiming.tank;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 19:02
 */
public class GoodTankFactory {

    public GoodTank getInstance(TankFrame tf) {
        return new GoodTank(200, 400, Dir.UP, Group.GOOD, tf);
    }
}
