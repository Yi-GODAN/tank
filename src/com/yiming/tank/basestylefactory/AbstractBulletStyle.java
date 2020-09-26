package com.yiming.tank.basestylefactory;

import java.awt.image.BufferedImage;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 08:14
 */
public abstract class AbstractBulletStyle {
    public abstract BufferedImage getBulletU();
    public abstract BufferedImage getBulletD();
    public abstract BufferedImage getBulletL();
    public abstract BufferedImage getBulletR();
}
