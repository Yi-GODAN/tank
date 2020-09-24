package com.yiming.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/23 15:15
 */
public class ResourceMgr {

    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bTankL, bTankU, bTankR, bTankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(new File("src\\images\\GoodTank1.png"));
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);
            tankD = ImageUtil.rotateImage(tankU, 180);
            bTankU = ImageIO.read(new File("src\\images\\BadTank1.png"));
            bTankL = ImageUtil.rotateImage(bTankU, -90);
            bTankR = ImageUtil.rotateImage(bTankU, 90);
            bTankD = ImageUtil.rotateImage(bTankU, 180);
            bulletU = ImageIO.read(new File("src\\images\\bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);

            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(new File("src\\images\\e" + (i + 1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
