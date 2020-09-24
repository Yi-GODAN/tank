package com.yiming.tank;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/22 09:35
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        //初始化坦克
        for (int i = 0; i < initTankCount; i++) {
            tf.tanks.add(new Tank(100 + i * 80, 50, Dir.DOWN, Group.BAD, tf));
        }

        while (true) {
            Thread.sleep(10);
            tf.repaint();
        }
    }
}
