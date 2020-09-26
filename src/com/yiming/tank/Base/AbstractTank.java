package com.yiming.tank.Base;

import com.yiming.tank.*;

import java.awt.*;
import java.util.Random;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 18:12
 */
public abstract class AbstractTank {

    public int SPEED = Integer.parseInt((String) PropertyMgr.get("TankSpeed"));
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();

    public int x, y;

    public TankFrame tf = null;
    public Rectangle rect = null;
    public FireStrategy fs = null;

    public abstract void paint(Graphics g);

    public abstract void move();

    public abstract void die();

    public abstract void fire();

    public abstract Rectangle getRect();

    public void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 32) y = 32;
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }
}
