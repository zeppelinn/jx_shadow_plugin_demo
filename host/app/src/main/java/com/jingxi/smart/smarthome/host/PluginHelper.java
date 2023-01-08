package com.jingxi.smart.smarthome.host;

import android.content.Context;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PluginHelper {

    public final static String PLUGIN_APK_NAME = "plugin.apk";

    public File pluginApkFile;

    public ExecutorService singlePool = Executors.newSingleThreadExecutor();

    private Context mContext;

    private static PluginHelper sInstance = new PluginHelper();

    public static PluginHelper getInstance() {
        return sInstance;
    }

    private PluginHelper() {
    }

    public void init(Context context) {
        pluginApkFile = new File(context.getFilesDir(), PLUGIN_APK_NAME);
        mContext = context.getApplicationContext();

        singlePool.execute(new Runnable() {
            @Override
            public void run() {
                preparePlugin();
            }
        });
    }

    private void preparePlugin() {
        try {
            InputStream is = mContext.getAssets().open(PLUGIN_APK_NAME);
            FileUtils.copyInputStreamToFile(is, pluginApkFile);
        } catch (IOException e) {
            throw new RuntimeException("从assets中复制apk出错", e);
        }
    }
}
