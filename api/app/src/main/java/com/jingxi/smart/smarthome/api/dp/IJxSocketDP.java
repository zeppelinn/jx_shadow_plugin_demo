package com.jingxi.smart.smarthome.api.dp;

import androidx.annotation.Nullable;

/**
 * 插座设备数据点
 * */
public interface IJxSocketDP {

    /**
     * 插座开关状态
     * @param index 开关位数
     * */
    boolean isPowerOn(int index);

    /**
     * 控制插座开关
     * */
    @Nullable
    Object getOperationPower(boolean isOn);
}
