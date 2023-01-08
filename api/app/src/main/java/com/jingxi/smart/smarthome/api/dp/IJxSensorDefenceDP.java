package com.jingxi.smart.smarthome.api.dp;

import androidx.annotation.Nullable;

/**
 * 传感器（安防类）
 * */
public interface IJxSensorDefenceDP {

    /**
     * 布防状态
     * */
    boolean isArmed();

    /**
     * 人感检测到人
     * */
    boolean isSomeoneDetected();

    /**
     * 红外幕帘检测到有人闯入
     * */
    boolean isSomeoneIntrude();

    /**
     * 红外幕帘检测到有人外出
     * */
    boolean isSomeoneOut();

    /**
     * 门磁闭合状态
     * */
    boolean isDoorOrWindowsContact();

    /**
     * 光照报警状态
     * */
    boolean isIlluminationAlarm();

    /**
     * 声光报警器是否报警
     * */
    boolean isSoundLightSensorAlarm();

    /**
     * 风雨传感器知否报警
     * */
    boolean isWindAndRainAlarm();

    /**
     * 修改设防撤防状态
     * */
    @Nullable
    Object getOperationSetArm(boolean isArmed);
}
