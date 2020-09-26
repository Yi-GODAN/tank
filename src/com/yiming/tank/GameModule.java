package com.yiming.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 16:46
 */
public class GameModule extends Frame {

    Tank myTank = new Tank(400, 3000, Dir.UP, Group.GOOD, this);

    List<Tank> tanks = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public GameModule() {
        int TankCount = Integer.parseInt((String) PropertyMgr.get("BadTankCount"));

        //初始化坦克
        for (int i = 0; i < TankCount; i++) {
            tanks.add(new Tank(100 + i * 80, 50, Dir.DOWN, Group.BAD, this));
        }
    }

    public Tank getMyTank() {
        return myTank;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("敌人的数量" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

    }

}

