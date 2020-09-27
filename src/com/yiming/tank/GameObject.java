package com.yiming.tank;

import java.awt.*;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 18:21
 */
public abstract class GameObject {
    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWight();
    public abstract int getHeight();
}
