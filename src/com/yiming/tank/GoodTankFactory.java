package com.yiming.tank;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 19:02
 */
public class GoodTankFactory {
    int TankCount = Integer.parseInt((String) PropertyMgr.get("GoodTankCount"));

    List<GoodTank> goodTanks = new ArrayList<>();

    /*public List<GoodTank> getInstance(TankFrame tf) {
        for (int i = 0; i < TankCount; i++) {
            goodTanks.add(new GoodTank(200 + 80*i, 400, Dir.UP, Group.GOOD, tf));
        }
        return goodTanks;
    }*/
    public GoodTank getInstance(TankFrame tf) {
        return new GoodTank(200, 400, Dir.UP, Group.GOOD, tf);
    }
}
