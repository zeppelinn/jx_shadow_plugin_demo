package com.jingxi.smart.smarthome.api;

import android.content.Context;

import androidx.annotation.NonNull;

import com.jingxi.smart.smarthome.api.bean.JxBaseDeviceBean;

import java.util.ArrayList;

/**
 * 定义在宿主里的接口，各插件apk需要实现该接口
 * */
public interface ISmartEngineManager {

    /**
     * host     - 宿主应用启动时调用，用于初始化插件
     * plugin   - 插件应用在此处应当实现智能家居sdk的初始化
     * */
    void moduleInit(Context context);

    /**
     * host     - 宿主应用获取设备列表
     * plugin   - 插件应用在此处将智能家居SDK中定义的设备转换成JxBaseDeviceBean返回给宿主
     * */
    ArrayList<JxBaseDeviceBean> getRoomList();

    /**
     * host     - 宿主应用控制设备
     * plugin   - 插件应用在此处将宿主应用下发的控制指令译成对应智能家居SDK的控制指令
     * */
    void controlDevice(@NonNull String deviceUniqueId, Object optObj);
}
