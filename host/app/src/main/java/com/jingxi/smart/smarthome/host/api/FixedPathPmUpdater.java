package com.jingxi.smart.smarthome.host.api;

import com.jingxi.smart.smarthome.holder.ISmartEngineUpdater;

import java.io.File;
import java.util.concurrent.Future;

public class FixedPathPmUpdater implements ISmartEngineUpdater {

    final private File apkFile;

    FixedPathPmUpdater(File apkFile) {
        this.apkFile = apkFile;
    }

    @Override
    public Future<File> update() {
        return null;
    }

    @Override
    public File getLatest() {
        return apkFile;
    }
}
