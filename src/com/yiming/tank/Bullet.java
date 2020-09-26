package com.yiming.tank;

import java.awt.*;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/22 21:20
 */
public class Bullet {
    private int SPEED = Integer.parseInt((String)PropertyMgr.get("BulletSpeed"));
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private int x, y;
    private Dir dir;

    private boolean living = true;
    private GameModule gm = null;
    private Group group = Group.BAD;

    //    private Rectangle rect = new Rectangle();
    private Rectangle rect = null;

    public Bullet(int x, int y, Dir dir, Group group, GameModule gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;

        rect = new Rectangle(this.x, this.y, Bullet.WIDTH, Bullet.HEIGHT);
        /*rect.x = this.x;
        rect.y = this.y;
        rect.width = Bullet.WIDTH;
        rect.height = Bullet.HEIGHT;*/

        gm.bullets.add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            gm.bullets.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
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
