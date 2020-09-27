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
public class TankTankColider implements Collider {
    @Override
    public boolean Collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                if (t1.getDir() == Dir.UP) t1.setDir(Dir.DOWN);
                else if (t1.getDir() == Dir.DOWN) t1.setDir(Dir.UP);
                else if (t1.getDir() == Dir.LEFT) t1.setDir(Dir.RIGHT);
                else if (t1.getDir() == Dir.RIGHT) t1.setDir(Dir.LEFT);
                else if (t2.getDir() == Dir.UP) t2.setDir(Dir.DOWN);
                else if (t2.getDir() == Dir.DOWN) t2.setDir(Dir.UP);
                else if (t2.getDir() == Dir.LEFT) t2.setDir(Dir.RIGHT);
                else t2.setDir(Dir.LEFT);
            }
            return false;
        }
        return true;
    }
}
