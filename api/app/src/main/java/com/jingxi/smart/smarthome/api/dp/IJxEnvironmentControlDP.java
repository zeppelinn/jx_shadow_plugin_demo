package com.jingxi.smart.smarthome.api.dp;

/**
 * 六恒系统
 * 有效功能 - pm25      co2
 * 有效功能 - sight_mode        switch
 * 有效功能 - switch    temp    humidity    temp_set
 * */
public interface IJxEnvironmentControlDP {

    float getPm25();

    float getCo2();

    boolean isOn();

    float getTemperatureInner();

    float getHumidityInner();

    float getTemperatureSet();

    /**
     * 空调设定温度范围
     * */
    int[] getTemperatureSetRange();

    /**
     * 获取控制温控器开关动作
     * */
    Object getSwitchControlOpt(boolean isOn);

    /**
     * 获取温控器设定温度动作
     * */
    Object getTemperatureSetOpt(int temperatureSet);
}
