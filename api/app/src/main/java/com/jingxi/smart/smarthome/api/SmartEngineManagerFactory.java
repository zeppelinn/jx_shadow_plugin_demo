package com.jingxi.smart.smarthome.api;

import android.content.Context;

/**
 * 宿主可以且仅可以通过工厂模式获取插件中的类
 */
public interface SmartEngineManagerFactory {
    ISmartEngineManagerImpl build(Context context);
}
