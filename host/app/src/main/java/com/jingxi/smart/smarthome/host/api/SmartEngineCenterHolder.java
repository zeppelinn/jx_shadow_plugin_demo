package com.jingxi.smart.smarthome.host.api;

import com.jingxi.smart.smarthome.api.ISmartEngineManager;
import com.jingxi.smart.smarthome.holder.SmartEngineCenter;

import java.io.File;

public class SmartEngineCenterHolder {

    public static ISmartEngineManager getSmartEngineManager(File apkFile) {
        final FixedPathPmUpdater fixedPathPmUpdater = new FixedPathPmUpdater(apkFile);
        File tempPm = fixedPathPmUpdater.getLatest();
        if (tempPm != null) {
            return new SmartEngineCenter(fixedPathPmUpdater);
        }
        return null;
    }
}
