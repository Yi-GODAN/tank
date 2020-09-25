package com.yiming.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 17:55
 */
public class GoodTankStyle1 {
    public static BufferedImage tankL, tankU, tankR, tankD;

    static {
        try {
            tankU = ImageIO.read(GoodTankStyle1.class.getClassLoader().getResourceAsStream(
                    (String) PropertyMgr.get("GoodTank_Image")));
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);
            tankD = ImageUtil.rotateImage(tankU, 180);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
