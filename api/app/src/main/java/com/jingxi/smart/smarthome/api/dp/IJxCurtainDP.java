package com.jingxi.smart.smarthome.api.dp;

import androidx.annotation.Nullable;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 窗帘设备数据点
 * */
public interface IJxCurtainDP {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({CurtainMotorState.ON, CurtainMotorState.OFF, CurtainMotorState.PAUSE, CurtainMotorState.NOT_SUPPORT})
    @interface CurtainMotorState {
        String ON = "on";                   //  打开窗帘
        String OFF = "off";                 //  关闭窗帘
        String PAUSE = "pause";             //  暂停窗帘
        String NOT_SUPPORT = "notSupport";  //  不支持控制
    }

    /**
     * 是否支持控制进度
     * */
    boolean supportProgressControl();

    /**
     * 获取当前窗帘开合进度
     * */
    int getProgress();

    /**
     * 支持的开、关、暂停功能
     * */
    String[] getSupportMotorControl();

    /**
     * 获取当前窗帘状态
     * */
    @CurtainMotorState
    String getMotorState();

    /**
     * 控制窗帘进度
     * */
    @Nullable
    Object getOperationProgress(int progress);

    /**
     * 控制窗帘状态
     * */
    @Nullable
    Object getOperationMotorState(@CurtainMotorState String motorState);
}
