package com.yiming.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Program: tank
 * @Description:
 * @Author: YiMing
 * @Created: 2020/09/24 10:54
 */
public class PropertyMgr {
    private static final PropertyMgr INSTANCE = new PropertyMgr();

    private PropertyMgr() {}

    public static PropertyMgr getInstance() {
        return INSTANCE;
    }

    private static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) return null;
        return props.get(key);
    }

}
