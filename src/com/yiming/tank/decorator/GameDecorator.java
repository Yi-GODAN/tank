package com.yiming.tank.decorator;

import com.yiming.tank.GameObject;

import java.awt.*;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/27 12:40
 */
public abstract class GameDecorator extends GameObject {

    GameObject go;

    public GameDecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public void paint(Graphics g) {
        go.paint(g);
    }

}
