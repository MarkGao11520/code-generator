package com.gwf.core.common.config;

import com.google.common.collect.Maps;
import com.gwf.core.common.util.PropertiesLoader;

import java.util.Map;

/**
 * Created with family.
 * author: cy
 * Date: 16/6/2
 * Time: 下午3:50
 * description: global config
 */
public class Global {
    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader propertiesLoader = new PropertiesLoader("classpath:/properties/auto.properties");

    /**
     * 获取管理端根路径
     */
    public static String getAdminPath() {
        return getConfig("backGroundPath");
    }

    /**
     * 获取前端根路径
     */
    public static String getFrontPath() {
        return getConfig("frontPath");
    }


    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null){
            value = propertiesLoader.getProperty(key);
            map.put(key, value);
        }
        return value;
    }
}
