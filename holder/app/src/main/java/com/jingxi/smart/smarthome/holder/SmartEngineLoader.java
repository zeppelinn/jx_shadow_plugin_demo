package com.jingxi.smart.smarthome.holder;

import android.content.Context;

import com.jingxi.smart.smarthome.api.ISmartEngineManagerImpl;
import com.jingxi.smart.smarthome.api.SmartEngineManagerFactory;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.apk.ApkClassLoader;
import com.tencent.shadow.dynamic.apk.ChangeApkContextWrapper;
import com.tencent.shadow.dynamic.apk.ImplLoader;

import java.io.File;

public class SmartEngineLoader extends ImplLoader {

    //  插件中的实现类，目前现在这里写死，之后可以由后台下发
    private static final String FACTORY_CLASS_NAME = "com.jingxi.smart.smarthome.plugin.api.PhilipsFactoryImpl";

    private static final String[] REMOTE_PLUGIN_MANAGER_INTERFACES = new String[] {
            "com.tencent.shadow.core.common",
            //  将宿主自定义的接口加入白名单
            "com.jingxi.smart.smarthome.api.bean"
    };

    final private Context applicationContext;
    final private InstalledApk installedApk;

    SmartEngineLoader(Context context, File apk) {
        applicationContext = context.getApplicationContext();
        File root = new File(applicationContext.getFilesDir(), "SmartEngineLoader");
        File odexDir = new File(root, Long.toString(apk.lastModified(), Character.MAX_RADIX));
        odexDir.mkdirs();
        installedApk = new InstalledApk(apk.getAbsolutePath(), odexDir.getAbsolutePath(), null);
    }

    /**
     * 加载一个插件
     * */
    ISmartEngineManagerImpl load() {
        ApkClassLoader apkClassLoader = new ApkClassLoader(installedApk, getClass().getClassLoader(), loadWhiteList(installedApk), 1);
        Context contextForApi = new ChangeApkContextWrapper(applicationContext, installedApk.apkFilePath, apkClassLoader);

        try {
            SmartEngineManagerFactory factory = apkClassLoader.getInterface(SmartEngineManagerFactory.class, FACTORY_CLASS_NAME);
            return factory.build(contextForApi);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String[] getCustomWhiteList() {
        return REMOTE_PLUGIN_MANAGER_INTERFACES;
    }
}
