package com.yiming.tank.decorator;

import com.yiming.tank.GameObject;

import java.awt.*;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/27 14:05
 */
public class TailDecorator extends GameDecorator{

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(go.x, go.y, super.go.x + getWight(), super.go.y + getHeight());
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
