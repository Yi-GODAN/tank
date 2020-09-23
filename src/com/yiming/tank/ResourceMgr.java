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
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankL = ImageIO.read(new File("src\\images\\tankL.gif"));
            tankU = ImageIO.read(new File("src\\images\\tankU.gif"));
            tankR = ImageIO.read(new File("src\\images\\tankR.gif"));
            tankD = ImageIO.read(new File("src\\images\\tankD.gif"));
            bulletL = ImageIO.read(new File("src\\images\\bulletL.gif"));
            bulletU = ImageIO.read(new File("src\\images\\bulletU.gif"));
            bulletR = ImageIO.read(new File("src\\images\\bulletR.gif"));
            bulletD = ImageIO.read(new File("src\\images\\bulletD.gif"));

            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(new File("src\\images\\e" + (i + 1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
