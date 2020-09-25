package com.yiming.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 18:30
 */
public class BadTank extends AbstractTank {

    private Random random = new Random();

    private boolean moving = true;
    private boolean living = true;

    Dir dir = Dir.UP;
    Group group = Group.BAD;

    BadTank() {
    }

    public BadTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect = new Rectangle(this.x, this.y, Bullet.WIDTH, Bullet.HEIGHT);

        String badName = (String) PropertyMgr.get("BadFS");
        try {
            fs = (FireStrategy) Class.forName(badName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        if (!living) tf.badTanks.remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bTankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bTankD, x, y, null);
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

        if (random.nextInt(100) > 96)
            this.fire();

        if (random.nextInt(100) > 97)
            randomDir();

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

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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
