package com.yiming.tank.cor;

import com.yiming.tank.Bullet;
import com.yiming.tank.GameObject;
import com.yiming.tank.Tank;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 19:47
 */
public class BulletTankColider implements Collider {
    @Override
    public boolean Collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            b.collideWith(t);
            return false;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            Collide(o2, o1);
        } else {
            return false;
        }
        return true;
    }
}
