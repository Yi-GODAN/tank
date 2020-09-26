package com.yiming.tank.basestylefactory.badstylefactory;

import com.yiming.tank.BadTankStyle;
import com.yiming.tank.basestylefactory.AbstractBulletStyle;
import com.yiming.tank.basestylefactory.AbstractExplodeStyle;
import com.yiming.tank.basestylefactory.AbstractStyleFactory;
import com.yiming.tank.basestylefactory.AbstractTankStyle;
import com.yiming.tank.basestylefactory.badstylefactory.BadBulletStyle;
import com.yiming.tank.basestylefactory.badstylefactory.BadExplodeStyle;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 17:46
 */
public class BadStyleFactory extends AbstractStyleFactory {
    @Override
    public AbstractTankStyle tankStyle() {
        return new BadTankStyle();
    }

    @Override
    public AbstractBulletStyle bulletStyle() {
        return new BadBulletStyle();
    }

    @Override
    public AbstractExplodeStyle explodeStyle() {
        return new BadExplodeStyle();
    }

}
