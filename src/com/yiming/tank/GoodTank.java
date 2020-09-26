package com.yiming.tank;

import com.yiming.tank.Base.AbstractTank;
import com.yiming.tank.basestylefactory.AbstractStyleFactory;
import com.yiming.tank.basestylefactory.goodstylefactory.GoodStyleFactory;

import java.awt.*;

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

    AbstractStyleFactory goodStyle = new GoodStyleFactory();

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
    public void paint(Graphics g) {
        if (!living) tf.myTank=null;

        switch (dir) {
            case LEFT:
                g.drawImage(goodStyle.tankStyle().getTankL(), x, y, null);
                break;
            case UP:
                g.drawImage(goodStyle.tankStyle().getTankU(), x, y, null);
                break;
            case RIGHT:
                g.drawImage(goodStyle.tankStyle().getTankR(), x, y, null);
                break;
            case DOWN:
                g.drawImage(goodStyle.tankStyle().getTankD(), x, y, null);
                break;
        }

        move();
    }

    @Override
    public void move() {
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
    public void die() {
        this.living = false;
        int eX = this.x + Tank.WIDTH / 2 - GoodExplode.WIDTH / 2;
        int eY = this.y + Tank.HEIGHT / 2 - GoodExplode.HEIGHT / 2;
        tf.goodExplodes.add(new GoodExplode(eX, eY, this.tf));
    }

    @Override
    public void fire() {
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
