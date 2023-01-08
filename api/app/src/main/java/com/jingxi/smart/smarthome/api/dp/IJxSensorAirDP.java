package com.jingxi.smart.smarthome.api.dp;

/**
 * 传感器（环境类）
 * */
public interface IJxSensorAirDP {

    /**
     * pm2.5指数
     * */
    int getPm25();

    /**
     * 甲醛指数
     * */
    int getFormaldehyde();

    /**
     * 二氧化碳指数
     * */
    int getCo2();

    /**
     * 温度
     * */
    int getTemperature();

    /**
     * 湿度
     * */
    int getHumidity();

    /**
     * 光照度
     * */
    int getIllumination();

    /**
     * 噪音
     * */
    int getNoise();
}
