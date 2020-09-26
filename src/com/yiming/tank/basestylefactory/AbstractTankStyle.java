package com.yiming.tank.basestylefactory;

import java.awt.image.BufferedImage;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 07:23
 */
public abstract class AbstractTankStyle {
    public abstract BufferedImage getTankU();
    public abstract BufferedImage getTankD();
    public abstract BufferedImage getTankL();
    public abstract BufferedImage getTankR();
}
