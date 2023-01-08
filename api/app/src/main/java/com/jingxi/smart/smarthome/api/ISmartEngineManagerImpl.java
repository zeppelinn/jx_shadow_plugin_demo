package com.jingxi.smart.smarthome.api;

import android.os.Bundle;

/**
 * 给接口ISmartEngineManager包装一层生命周期
 * 可以使插件感知加载过程
 */
public interface ISmartEngineManagerImpl extends ISmartEngineManager {

    void onCreate(Bundle bundle);

    void onSaveInstanceState(Bundle outState);

    void onDestroy();
}
