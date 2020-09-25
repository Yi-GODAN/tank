package com.yiming.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 18:04
 */
public class GoodBulletStyle1 {

    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    static {
        try {
            bulletU = ImageIO.read(GoodBulletStyle1.class.getClassLoader().getResourceAsStream(
                    (String) PropertyMgr.get("Bullet_Image")));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
