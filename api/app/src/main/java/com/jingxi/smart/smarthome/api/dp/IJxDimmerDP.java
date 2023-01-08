package com.jingxi.smart.smarthome.api.dp;

import androidx.annotation.Nullable;

/**
 * 调光设备数据点
 * */
public interface IJxDimmerDP {

    /**
     * 是否打开
     * */
    boolean isOn();

    /**
     * 是否支持亮度控制
     * */
    boolean supportControlBrightness();

    /**
     * 获取当前亮度
     * */
    int getBrightness();

    /**
     * 是否支持控制色温
     * */
    boolean supportControlColorTemperature();

    /**
     * 获取当前色温值
     * */
    int getColorTemperature();

    /**
     * 是否支持控制颜色
     * */
    boolean supportControlRGB();

    /**
     * 获取当前RGB值
     * */
    int[] getRGB();

    /**
     * 控制RGB动作
     * */
    @Nullable
    Object getOperationRGB(int colorR, int colorG, int colorB);

    /**
     * 控制亮度动作
     * */
    @Nullable
    Object getOperationBrightness(int brightness);

    /**
     * 控制色温动作
     * */
    @Nullable
    Object getOperationColorTemperature(int colorTemperature);

}
