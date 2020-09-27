package com.yiming.tank.decorator;

import com.yiming.tank.GameObject;

import java.awt.*;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/27 12:43
 */
public class RectDecorator extends GameDecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = x;
        this.y = y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.drawRect(super.go.x, super.go.y, super.go.getWight() + 2, super.go.getHeight() + 2);
        g.setColor(c);
    }

    @Override
    public int getWight() {
        return super.go.getWight();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
