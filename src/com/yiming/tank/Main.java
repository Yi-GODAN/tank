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

        int TankCount = Integer.parseInt((String) PropertyMgr.get("BadTankCount"));

        //初始化坦克
        /*for (int i = 0; i < TankCount; i++) {
            tf.tanks.add(new Tank(100 + i * 80, 50, Dir.DOWN, Group.BAD, tf));
        }*/
//        tf.goodTanks.addAll(0, new GoodTankFactory().getInstance(tf));

        tf.badTanks.addAll(0, new BadTankFactory().getInstance(tf));

        while (true) {
            Thread.sleep(10);
            tf.repaint();
        }
    }
}
