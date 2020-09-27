package com.yiming.tank.cor;

import com.yiming.tank.Bullet;
import com.yiming.tank.GameObject;
import com.yiming.tank.Wall;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/27 10:07
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean Collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            if (b.getRect().intersects(w.getRect())) {
                b.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            Collide(o2, o1);
        }
        return true;
    }
}
