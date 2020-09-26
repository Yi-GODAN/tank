package com.yiming.tank.basestylefactory;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 17:34
 */
public abstract class AbstractStyleFactory {
    public abstract AbstractTankStyle tankStyle();
    public abstract AbstractBulletStyle bulletStyle();
    public abstract AbstractExplodeStyle explodeStyle();
}
