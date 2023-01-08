package com.jingxi.smart.smarthome.host;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jingxi.smart.smarthome.api.ISmartEngineManager;
import com.jingxi.smart.smarthome.api.bean.JxBaseDeviceBean;
import com.jingxi.smart.smarthome.host.api.SmartEngineCenterHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mPlugin";

    private TextView txtDev1, txtDev2;
    private ImageView imgDev1, imgDev2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loadPlugin();
    }

    private void loadPlugin() {
        PluginHelper.getInstance().singlePool.execute(new Runnable() {
            @Override
            public void run() {
                final ISmartEngineManager smartEngineManager = SmartEngineCenterHolder.getSmartEngineManager(PluginHelper.getInstance().pluginApkFile);
                Log.i(TAG, "run: smartEngineManager = " + smartEngineManager);
                if (smartEngineManager == null) return;
                smartEngineManager.moduleInit(MainActivity.this);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<JxBaseDeviceBean> deviceList = smartEngineManager.getRoomList();
                        Log.i(TAG, "run: deviceList = " + deviceList);
                        if (deviceList != null && deviceList.size() == 2) {
                            JxBaseDeviceBean deviceBean1 = deviceList.get(0);
                            JxBaseDeviceBean deviceBean2 = deviceList.get(1);

                            txtDev1.setText(deviceBean1.getDeviceName());
                            txtDev2.setText(deviceBean2.getDeviceName());

                            Log.i(TAG, "run: deviceBean1.getDeviceName() = " + deviceBean1.getDeviceName());
                        }
                    }
                });
            }
        });
    }

    private void init() {
        txtDev1 = findViewById(R.id.txt_dev_1);
        txtDev2 = findViewById(R.id.txt_dev_2);
        imgDev1 = findViewById(R.id.img_dev_1);
        imgDev2 = findViewById(R.id.img_dev_2);
    }

}