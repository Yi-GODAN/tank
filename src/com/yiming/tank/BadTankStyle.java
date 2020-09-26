package com.yiming.tank;

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
public class BadTankStyle extends AbstractTankStyle {

    public static BufferedImage tankL, tankU, tankR, tankD;

    static {
        try {
            tankU = ImageIO.read(BadTankStyle.class.getClassLoader().getResourceAsStream(
                    (String) PropertyMgr.get("BadTank_Image")));
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
