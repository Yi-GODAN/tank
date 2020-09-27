package com.yiming.tank.observer;

import com.yiming.tank.Tank;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/27 17:13
 */
public class TankFireHandler implements TankFireObserver{


    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
