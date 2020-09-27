package com.yiming.tank.cor;

import com.yiming.tank.GameObject;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 19:43
 */
public interface Collider {
    boolean Collide(GameObject o1, GameObject o2);
}
