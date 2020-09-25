package com.yiming.tank;

import java.awt.Image;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/22 10:55
 */
public class TankFrame extends Frame {

    static int GAME_WIDTH = Integer.parseInt((String)PropertyMgr.get("GAME_WIDTH"));
    static int GAME_HEIGHT = Integer.parseInt((String)PropertyMgr.get("GAME_HEIGHT"));

    GoodTank myTank = new GoodTankFactory().getInstance(this);

    List<Tank> tanks = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();
    List<BadTank> badTanks = new ArrayList<>();


    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
//        g.drawString("敌人的数量" + tanks.size(), 10, 80);
        g.drawString("敌人的数量" + badTanks.size(), 10, 80);
        g.drawString("爆炸的数量" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < badTanks.size(); i++) {
            badTanks.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < badTanks.size(); j++) {
                bullets.get(i).collideWith2(badTanks.get(j));
            }
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

    }

    // key listener
    class MyKeyListener extends KeyAdapter {

        boolean bU = false;
        boolean bD = false;
        boolean bL = false;
        boolean bR = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }
    }
}
