package com.hanrideb.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    private ConfigurationManager() {
    }

    public static Configuration configuration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }

    public static Boolean getHeadless(){
       // String headless = System.getProperty("headless");

        if (!(System.getProperty("headless") == null))
            return System.getProperty("headless").equals("true") ? true : false;

        return configuration().headless();

    }

}
