package com.yiming.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/22 19:07
 */
public class Tank {
    private static final int SPEED = 3;
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();

    private Random random = new Random();

    private int x, y;

    private Dir dir = Dir.UP;

    private boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;
    private Group group = Group.BAD;

    public Tank() {
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) tf.tanks.remove(this);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }
        move();
    }

    public void die() {
        this.living = false;
    }

    private void move() {
        if (!moving) return;
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
        }

        if (random.nextInt(10) > 8) this.fire();
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.HEIGHT / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
