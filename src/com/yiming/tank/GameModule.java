package com.yiming.tank;

import com.yiming.tank.cor.ColliderChain;

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

    private static final GameModule INSTANCE = new GameModule();

    public static GameModule getInstance() {
        return INSTANCE;
    }

    static final int GAME_WIDTH = Integer.parseInt((String) PropertyMgr.get("GAME_WIDTH"));
    static final int GAME_HEIGHT = Integer.parseInt((String) PropertyMgr.get("GAME_HEIGHT"));

    Tank myTank = new Tank(400, 3000, Dir.UP, Group.GOOD);

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

    private GameModule() {
        int TankCount = Integer.parseInt((String) PropertyMgr.get("BadTankCount"));

        //初始化敌方坦克
        for (int i = 0; i < TankCount; i++) {
            add(new Tank(100 + i * 80, 40, Dir.DOWN, Group.BAD));
        }

        //初始化墙
        add(new Wall(150, 200, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(150, 350, 50, 200));
        add(new Wall(400, 400, 200, 50));
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
                chain.collide(o1, o2);
            }
        }

    }

}

