package com.jingxi.smart.smarthome.host;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.webkit.WebView;

import com.tencent.shadow.core.common.LoggerFactory;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        detectNonSdkApiUsageOnAndroidP();
        setWebViewDataDirectorySuffix();

        LoggerFactory.setILoggerFactory(new AndroidLogLoggerFactory());
        PluginHelper.getInstance().init(this);
    }

    private static void setWebViewDataDirectorySuffix() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            return;
        }
        WebView.setDataDirectorySuffix(Application.getProcessName());
    }

    private static void detectNonSdkApiUsageOnAndroidP() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            return;
        }
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        builder.detectNonSdkApiUsage();
        StrictMode.setVmPolicy(builder.build());
    }
}
