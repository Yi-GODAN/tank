package com.yiming.tank.basestylefactory.goodstylefactory;

import com.yiming.tank.ImageUtil;
import com.yiming.tank.PropertyMgr;
import com.yiming.tank.basestylefactory.AbstractTankStyle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 17:55
 */
public class GoodTankStyle extends AbstractTankStyle {

    public static BufferedImage tankL, tankU, tankR, tankD;

    static {
        try {
            tankU = ImageIO.read(GoodTankStyle.class.getClassLoader().getResourceAsStream(
                    (String) PropertyMgr.get("GoodTank_Image")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getTankU() {
        return tankU;
    }

    public BufferedImage getTankD() {
        return ImageUtil.rotateImage(tankU, 180);
    }

    public BufferedImage getTankL() {
        return ImageUtil.rotateImage(tankU, -90);
    }

    public BufferedImage getTankR() {
        return ImageUtil.rotateImage(tankU, 90);
    }

}
