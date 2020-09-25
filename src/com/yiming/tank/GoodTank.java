package com.yiming.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 18:22
 */
public class GoodTank extends AbstractTank {

    private boolean moving = true;
    private boolean living = true;

    Dir dir = Dir.UP;
    Group group = Group.GOOD;

    GoodTank() {
    }

    public GoodTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect = new Rectangle(this.x, this.y, Bullet.WIDTH, Bullet.HEIGHT);

        try {
            String goodName = (String) PropertyMgr.get("GoodFS");
            fs = (FireStrategy) Class.forName(goodName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    void paint(Graphics g) {
//        if (!living) tf.myTank.remove(this);

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

    @Override
    void move() {
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

        boundsCheck();

        // update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    @Override
    void die() {
        this.living = false;
        int eX = this.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
        int eY = this.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
        tf.explodes.add(new Explode(eX, eY, this.tf));
    }

    @Override
    void fire() {
        fs.fire(this);
    }

    @Override
    public Rectangle getRect() {
        return rect;
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
