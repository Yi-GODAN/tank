package com.yiming.tank.cor;

import com.yiming.tank.Dir;
import com.yiming.tank.GameObject;
import com.yiming.tank.Tank;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 19:47
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean Collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.back();
                t2.back();
            }
            return false;
        }
        return true;
    }
}
