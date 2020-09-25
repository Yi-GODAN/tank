package com.yiming.tank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/25 19:07
 */
public class BadTankFactory {

    int TankCount = Integer.parseInt((String) PropertyMgr.get("BadTankCount"));

    List<BadTank> badTanks = new ArrayList<>();

    public List<BadTank> getInstance(TankFrame tf) {
        for (int i = 0; i < TankCount; i++) {
            badTanks.add(new BadTank(100 + i * 80, 50, Dir.DOWN, Group.BAD, tf));
        }
        return badTanks;
    }


}
