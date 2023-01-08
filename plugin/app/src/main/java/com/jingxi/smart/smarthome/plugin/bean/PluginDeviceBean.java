package com.jingxi.smart.smarthome.plugin.bean;

import com.jingxi.smart.smarthome.api.bean.JxBaseDeviceBean;

public class PluginDeviceBean extends JxBaseDeviceBean {

    public PluginDeviceBean(String devId, String devName, int imgRes) {
        this.deviceName = devName;
        this.deviceUniqueId = devId;
        this.iconRes = imgRes;
    }
}
