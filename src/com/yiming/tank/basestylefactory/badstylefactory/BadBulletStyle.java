package com.yiming.tank.basestylefactory.badstylefactory;

import com.yiming.tank.ImageUtil;
import com.yiming.tank.PropertyMgr;
import com.yiming.tank.basestylefactory.AbstractBulletStyle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 18:04
 */
public class BadBulletStyle extends AbstractBulletStyle {

    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    static {
        try {
            bulletU = ImageIO.read(BadBulletStyle.class.getClassLoader().getResourceAsStream(
                    (String) PropertyMgr.get("BadBullet_Image")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBulletU() {
        return bulletU;
    }

    public BufferedImage getBulletD() {
        return ImageUtil.rotateImage(bulletU, 180);
    }

    public BufferedImage getBulletL() {
        return ImageUtil.rotateImage(bulletU, -90);
    }

    public BufferedImage getBulletR() {
        return ImageUtil.rotateImage(bulletU, 90);
    }
}
