package com.yiming.tank.cor;

import com.yiming.tank.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 21:35
 */
public class ColliderChain {
    private List<Collider> colliders = new ArrayList<>();


    public ColliderChain() {
        try {
            add(new BulletTankCollider());
            add(new TankTankCollider());
            add(new BulletWallCollider());
            add(new TankWallCollider());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Collider c) {
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).Collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
