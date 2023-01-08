package com.jingxi.smart.smarthome.holder;

import static com.tencent.shadow.core.utils.Md5.md5File;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import com.jingxi.smart.smarthome.api.ISmartEngineManager;
import com.jingxi.smart.smarthome.api.ISmartEngineManagerImpl;
import com.jingxi.smart.smarthome.api.bean.JxBaseDeviceBean;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

public class SmartEngineCenter implements ISmartEngineManager {

    final private ISmartEngineUpdater mUpdater;
    private ISmartEngineManagerImpl mSmartEngineManagerImpl;
    private String mCurrentImplMd5;
    private static final Logger mLogger = LoggerFactory.getLogger(SmartEngineCenter.class);

    public SmartEngineCenter(ISmartEngineUpdater mUpdater) {
        if (mUpdater.getLatest() == null) {
            throw new IllegalArgumentException("构造DynamicPluginManager时传入的PluginManagerUpdater" +
                    "必须已经已有本地文件，即getLatest()!=null");
        }
        this.mUpdater = mUpdater;
    }


    @Override
    public void moduleInit(Context context) {
        if (mLogger.isInfoEnabled()) {
            mLogger.info("moduleInit: context" + context);
        }
        //  初始化模块
        updateImpl(context);
        if (mSmartEngineManagerImpl != null) {
            mSmartEngineManagerImpl.moduleInit(context);
        }
        mUpdater.update();
    }

    @Override
    public ArrayList<JxBaseDeviceBean> getRoomList() {
        if (mSmartEngineManagerImpl == null) return new ArrayList<>();
        return mSmartEngineManagerImpl.getRoomList();
    }

    @Override
    public void controlDevice(String s, Object o) {
        if (mSmartEngineManagerImpl == null) return;
        mSmartEngineManagerImpl.controlDevice(s, o);
    }

    private void updateImpl(Context context) {
        File latestImplApk = mUpdater.getLatest();
        String md5 = md5File(latestImplApk);
        if (mLogger.isInfoEnabled()) {
            mLogger.info("TextUtils.equals(mCurrentImplMd5, md5) : " + (TextUtils.equals(mCurrentImplMd5, md5)));
        }
        if (!TextUtils.equals(mCurrentImplMd5, md5)) {
            SmartEngineLoader implLoader = new SmartEngineLoader(context, latestImplApk);
            ISmartEngineManagerImpl newImpl = implLoader.load();
            Bundle state;
            if (mSmartEngineManagerImpl != null) {
                state = new Bundle();
                mSmartEngineManagerImpl.onSaveInstanceState(state);
                mSmartEngineManagerImpl.onDestroy();
            } else {
                state = null;
            }
            newImpl.onCreate(state);
            mSmartEngineManagerImpl = newImpl;
            mCurrentImplMd5 = md5;
        }
    }

    public ISmartEngineManagerImpl getmSmartEngineManagerImpl() {
        return mSmartEngineManagerImpl;
    }
}
