package com.yiming.tank;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 08:49
 */
public interface FireStrategy {
    void fire(Tank tank);
    void fire(GoodTank tank);
    void fire(BadTank tank);
}
