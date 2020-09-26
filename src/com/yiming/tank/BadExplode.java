package com.yiming.tank;

import com.yiming.tank.Base.AbstractExplode;
import com.yiming.tank.basestylefactory.AbstractStyleFactory;
import com.yiming.tank.basestylefactory.badstylefactory.BadStyleFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/22 21:20
 */
public class BadExplode extends AbstractExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;

    private int count = 0;

    private boolean living = true;
    TankFrame tf = null;

    private int step = 0;

    AbstractStyleFactory styleFactory = new BadStyleFactory();
    BufferedImage[] bufferedImages = styleFactory.explodeStyle().getExplodes();

    public BadExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
//        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(bufferedImages[step++], x, y, null);

        if (step >= bufferedImages.length) {
            tf.badExplodes.remove(this);
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLiving() {
        return living;
    }

}
