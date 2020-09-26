package com.yiming.tank;

import com.yiming.tank.Base.AbstractBullet;
import com.yiming.tank.basestylefactory.AbstractStyleFactory;
import com.yiming.tank.basestylefactory.goodstylefactory.GoodStyleFactory;

import java.awt.*;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/22 21:20
 */
public class GoodBullet extends AbstractBullet {
    private int SPEED = Integer.parseInt((String) PropertyMgr.get("BulletSpeed"));
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private int x, y;
    private Dir dir;

    private boolean living = true;
    private TankFrame tf = null;
    private Group group = Group.BAD;

    private Rectangle rect = null;

    AbstractStyleFactory styleFactory = new GoodStyleFactory();

    public GoodBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect = new Rectangle(this.x, this.y, GoodBullet.WIDTH, GoodBullet.HEIGHT);

        tf.goodBullets.add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.goodBullets.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(styleFactory.bulletStyle().getBulletL(), x, y, null);
                break;
            case UP:
                g.drawImage(styleFactory.bulletStyle().getBulletU(), x, y, null);
                break;
            case RIGHT:
                g.drawImage(styleFactory.bulletStyle().getBulletR(), x, y, null);
                break;
            case DOWN:
                g.drawImage(styleFactory.bulletStyle().getBulletD(), x, y, null);
                break;
        }

        move();
    }

    public void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;

        // update rect
        rect.x = this.x;
        rect.y = this.y;
    }


    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;

        //TODO：用一个rect来记录子弹的位置 (已修复)：使tank和Bullet各自维护一个Rectangle
        if (rect.intersects(tank.getRect())) {
            tank.die();
            this.die();
        }
    }

    public void collideWith2(BadTank tank) {
        if (this.group == tank.group) return;

        //TODO：用一个rect来记录子弹的位置 (已修复)：使tank和Bullet各自维护一个Rectangle
        if (rect.intersects(tank.getRect())) {
            tank.die();
            this.die();
        }
    }

    public void collideWith3(GoodTank tank) {
        if (this.group == tank.group) return;

        //TODO：用一个rect来记录子弹的位置 (已修复)：使tank和Bullet各自维护一个Rectangle
        if (rect.intersects(tank.getRect())) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
