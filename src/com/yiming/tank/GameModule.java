package com.yiming.tank;

import com.yiming.tank.cor.BulletTankColider;
import com.yiming.tank.cor.Collider;
import com.yiming.tank.cor.ColliderChain;
import com.yiming.tank.cor.TankTankColider;

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

    Collider collider = new BulletTankColider();
    Collider collider2 = new TankTankColider();

    /*List<Tank> tanks = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();*/
    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public GameModule() {
        int TankCount = Integer.parseInt((String) PropertyMgr.get("BadTankCount"));

        //初始化坦克
        for (int i = 0; i < TankCount; i++) {
            add(new Tank(100 + i * 80, 50, Dir.DOWN, Group.BAD, this));
        }
    }

    public Tank getMyTank() {
        return myTank;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
/*      g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("敌人的数量" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量" + explodes.size(), 10, 100);*/
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        // 相互碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {  // Comparator.compare(o1,o2)
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                // for
                chain.collide(o1, o2);
            }
        }

        /*for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }*/

    }

}

