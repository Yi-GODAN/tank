package com.yiming.tank.cor;

import com.yiming.tank.GameObject;
import com.yiming.tank.Tank;
import com.yiming.tank.Wall;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/27 10:47
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean Collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;

            if (t.rect.intersects(w.rect)) {
                t.back();
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            Collide(o2, o1);
        }
        return true;
    }
}
