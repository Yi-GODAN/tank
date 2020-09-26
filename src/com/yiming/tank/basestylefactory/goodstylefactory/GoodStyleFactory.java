package com.yiming.tank.basestylefactory.goodstylefactory;

import com.yiming.tank.basestylefactory.AbstractBulletStyle;
import com.yiming.tank.basestylefactory.AbstractExplodeStyle;
import com.yiming.tank.basestylefactory.AbstractStyleFactory;
import com.yiming.tank.basestylefactory.AbstractTankStyle;
import com.yiming.tank.basestylefactory.goodstylefactory.GoodBulletStyle;
import com.yiming.tank.basestylefactory.goodstylefactory.GoodExplodeStyle;
import com.yiming.tank.basestylefactory.goodstylefactory.GoodTankStyle;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 17:46
 */
public class GoodStyleFactory extends AbstractStyleFactory {

    @Override
    public AbstractTankStyle tankStyle() {
        return new GoodTankStyle();
    }

    @Override
    public AbstractBulletStyle bulletStyle() {
        return new GoodBulletStyle();
    }

    @Override
    public AbstractExplodeStyle explodeStyle() {
        return new GoodExplodeStyle();
    }
}
