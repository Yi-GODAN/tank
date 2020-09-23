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

        //初始化坦克
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(100 + i*80, 50, Dir.DOWN, tf));
        }

        while (true) {
            Thread.sleep(10);
            tf.repaint();
        }
    }
}
