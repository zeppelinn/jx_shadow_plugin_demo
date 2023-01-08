package com.jingxi.smart.smarthome.plugin.api;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.jingxi.smart.smarthome.api.ISmartEngineManagerImpl;
import com.jingxi.smart.smarthome.api.bean.JxBaseDeviceBean;
import com.jingxi.smart.smarthome.plugin.R;
import com.jingxi.smart.smarthome.plugin.bean.PluginDeviceBean;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHHueParsingError;

import java.util.ArrayList;
import java.util.List;

public class SampleSmartEngineManagerImpl implements ISmartEngineManagerImpl {

    private static final String TAG = "mPlugin";
    
    private Context context;

    private PHHueSDK mPhHueSDK;

    @Override
    public void onCreate(Bundle bundle) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void moduleInit(Context context) {
        this.context = context;
        Log.i("mPlugin", "moduleInit: ");
        // Gets an instance of the Hue SDK.
        mPhHueSDK = PHHueSDK.create();
        // Set the Device Name (name of your app). This will be stored in your bridge whitelist entry.
        mPhHueSDK.setAppName("SmartDeviceCenter");
        mPhHueSDK.setDeviceName(Build.MODEL);
        // Register the PHSDKListener to receive callbacks from the bridge.
        mPhHueSDK.getNotificationManager().registerSDKListener(new PHSDKListener() {
            @Override
            public void onCacheUpdated(List<Integer> list, PHBridge phBridge) {
                Log.i(TAG, "onCacheUpdated: ");
            }

            @Override
            public void onBridgeConnected(PHBridge phBridge, String s) {
                Log.i(TAG, "onBridgeConnected: ");
            }

            @Override
            public void onAuthenticationRequired(PHAccessPoint phAccessPoint) {
                Log.i(TAG, "onAuthenticationRequired: ");
            }

            @Override
            public void onAccessPointsFound(List<PHAccessPoint> list) {
                Log.i(TAG, "onAccessPointsFound: ");
            }

            @Override
            public void onError(int i, String s) {
                Log.i(TAG, "onError: ");
            }

            @Override
            public void onConnectionResumed(PHBridge phBridge) {
                Log.i(TAG, "onConnectionResumed: ");
            }

            @Override
            public void onConnectionLost(PHAccessPoint phAccessPoint) {
                Log.i(TAG, "onConnectionLost: ");
            }

            @Override
            public void onParsingErrors(List<PHHueParsingError> list) {
                Log.i(TAG, "onParsingErrors: ");
            }
        });
        PHBridge selectedBridge = mPhHueSDK.getSelectedBridge();
        Log.i("mPlugin", "moduleInit: selectedBridge = " + selectedBridge);

    }

    @Override
    public ArrayList<JxBaseDeviceBean> getRoomList() {
        ArrayList<JxBaseDeviceBean> list = new ArrayList<>();
        if (context == null) return list;
        String name1 = "飞利浦灯带";
        String name2 = "飞利浦灯球";
        Log.i(TAG, "getRoomList: name1 = " + name1);
        list.add(new PluginDeviceBean("1", name1, R.mipmap.icon_device_lamp));
        list.add(new PluginDeviceBean("2", name2, R.mipmap.icon_device_lamp));
        return list;
    }

    @Override
    public void controlDevice(String s, Object o) {
        Log.i("mPlugin", "controlDevice: s = " + s + "\to = " + o);
    }
}
