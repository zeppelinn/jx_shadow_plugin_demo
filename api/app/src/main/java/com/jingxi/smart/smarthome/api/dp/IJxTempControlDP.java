package com.jingxi.smart.smarthome.api.dp;

/**
 * 温控设备数据点
 * */
public interface IJxTempControlDP {

    /**
     * 获取温控器类型
     * */
    int getTempControlType();

    /**
     * 开关
     * */
    boolean isOn();

    /**
     * 空调设定温度范围
     * */
    int[] getTemperatureSetRange();

    /**
     * 空调设定温度
     * */
    float getTemperatureSet();

    /**
     * 获取室内温度
     * */
    float getTemperatureInner();

    /**
     * 获取室内湿度
     * */
    float getHumidityInner();

    /**
     * 获取风速设置
     * */
    int getFanSpeedSet();

    /**
     * 获取支持的风速
     * */
    int[] getFanSpeedSetRange();

    /**
     * 获取模式设置
     * */
    int getModeSet();

    /**
     * 获取支持设置的模式
     * */
    int[] getModeSetRange();

    /**
     * 获取当前风向
     * */
    int getFanDirectionSet();

    /**
     * 获取支持的风向
     * */
    int[] getFanDirectionSetRange();

    /**
     * 温控器错误码
     * */
    String getErrorMessage();

    /**
     * 获取控制温控器开关动作
     * */
    Object getSwitchControlOpt(boolean isOn);

    /**
     * 获取温控器设定温度动作
     * */
    Object getTemperatureSetOpt(int temperatureSet);

    /**
     * 获取温控器风速设定动作
     * */
    Object getFanSpeedSetOpt(int fanSpeedSet);

    /**
     * 控制温控器风向
     * */
    Object getFanDirectionSetOpt(int fanDirection);

    /**
     * 获取温控器模式设定动作
     * */
    Object getModeSetOpt(int mode);
}
