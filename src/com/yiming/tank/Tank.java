package com.yiming.tank;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/22 19:07
 */
public class Tank extends GameObject{
    private int SPEED = Integer.parseInt((String) PropertyMgr.get("TankSpeed"));
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();

    private Random random = new Random();

    int x, y;
    int oldx, oldy;

    Dir dir = Dir.UP;
    Group group = Group.BAD;

    private boolean moving = true;

    private boolean living = true;

    public Rectangle rect = new Rectangle();

    FireStrategy fs = null;

    public Tank() {
    }

    public Tank(int x, int y, Dir dir, Group group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = Tank.WIDTH;
        rect.height = Tank.HEIGHT;

        if (this.group == Group.GOOD) {
            try {
                String goodName = (String) PropertyMgr.get("GoodFS");
                fs = (FireStrategy) Class.forName(goodName).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            String badName = (String) PropertyMgr.get("BadFS");
            try {
                fs = (FireStrategy) Class.forName(badName).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        if (!living) GameModule.getInstance().remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.tankL : ResourceMgr.bTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.tankU : ResourceMgr.bTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.tankR : ResourceMgr.bTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.tankD : ResourceMgr.bTankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        this.oldx = this.x;
        this.oldy = this.y;

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

        if (this.group == group.BAD && random.nextInt(100) > 96)
            this.fire();

        if (this.group == group.BAD && random.nextInt(100) > 97)
            randomDir();

        boundsCheck();

        // update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 32) y = 32;
        if (this.x > GameModule.GAME_WIDTH - Tank.WIDTH - 2) x = GameModule.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > GameModule.GAME_HEIGHT - Tank.HEIGHT - 2) y = GameModule.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void die() {
        this.living = false;
        int eX = this.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
        int eY = this.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
        GameModule.getInstance().add(new Explode(eX, eY));
    }

    public void fire() {
        fs.fire(this);
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Rectangle getRect() {
        return rect;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void back() {
        x = oldx;
        y = oldy;
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public int getOldx() {
        return oldx;
    }

    public int getOldy() {
        return oldy;
    }

}
