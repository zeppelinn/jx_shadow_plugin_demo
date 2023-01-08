package com.jingxi.smart.smarthome.plugin.api;

import android.content.Context;

import com.jingxi.smart.smarthome.api.ISmartEngineManagerImpl;
import com.jingxi.smart.smarthome.api.SmartEngineManagerFactory;

public class PhilipsFactoryImpl implements SmartEngineManagerFactory {
    @Override
    public ISmartEngineManagerImpl build(Context context) {
        return new SampleSmartEngineManagerImpl();
    }
}
