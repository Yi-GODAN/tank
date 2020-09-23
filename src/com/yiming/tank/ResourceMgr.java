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

    static {
        try {
            tankL = ImageIO.read(new File("src\\images\\tankL.gif"));;
            tankU = ImageIO.read(new File("src\\images\\tankU.gif"));;
            tankR = ImageIO.read(new File("src\\images\\tankR.gif"));;
            tankD = ImageIO.read(new File("src\\images\\tankD.gif"));;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
