package com.yiming.tank;

import java.awt.*;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/27 09:35
 */
public class Wall extends GameObject {

    int w, h;

    public Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }

    @Override
    public int getWight() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }

    public Rectangle getRect() {
        return rect;
    }
}
