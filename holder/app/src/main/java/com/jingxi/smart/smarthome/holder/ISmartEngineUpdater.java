package com.jingxi.smart.smarthome.holder;

import java.io.File;
import java.util.concurrent.Future;

/**
 * 插件文件升级接口
 * 提供需要升级时的功能，比如下载或者向后台请求文件是否有更新等
 * */
public interface ISmartEngineUpdater {

    Future<File> update();

    File getLatest();
}
