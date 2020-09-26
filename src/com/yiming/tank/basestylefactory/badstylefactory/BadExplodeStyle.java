package com.yiming.tank.basestylefactory.badstylefactory;

import com.yiming.tank.ResourceMgr;
import com.yiming.tank.basestylefactory.AbstractExplodeStyle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/26 09:26
 */
public class BadExplodeStyle extends AbstractExplodeStyle {
    public static BufferedImage[] explodes = new BufferedImage[16];

    public BufferedImage[] getExplodes() {
        for (int i = 0; i < 16; i++) {
            try {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream(
                        "images/e" + (i + 1) + ".gif"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return explodes;
    }
}
