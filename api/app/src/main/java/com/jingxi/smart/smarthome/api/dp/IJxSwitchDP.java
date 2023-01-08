package com.jingxi.smart.smarthome.api.dp;

/**
 * 开关设备数据点
 * */
public interface IJxSwitchDP {

    /**
     * 总开关状态
     * */
    boolean isAllOn();

    /**
     * 每位开关状态
     * @param index 开关位数
     * */
    boolean isSwitchOn(int index);

    /**
     * 获取开关总位数
     * */
    int getSwitchCount();

}
