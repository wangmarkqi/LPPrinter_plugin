package com.example.utils;


import android.util.Log;

import com.dothantech.lpapi.LPAPI;
import com.dothantech.lpapi.IAtBitmap.DrawParamName;
import com.dothantech.lpapi.LPAPI.Factory;

public class Qr {
    private LPAPI api;

    public void onCreate() {
        this.api = LPAPI.Factory.createInstance();
        // 连接配对的第一个打印机对象
        api.openPrinter(null);
    }

    public void onDestroy() {
        // 断开蓝牙连接，释放 LPAPI 对象
        api.quit();
    }

    public void printQr40_30(String title, String qr, String txt) {
        // 开始绘图任务，传入参数(页面宽度, 页面高度 默认40*30)
        api.startJob(40, 30, 0);
        api.drawTextRegular(title, 27, 1, 12, 4, 4, 1);
        api.drawTextRegular(txt, 27, 5, 12, 25, 3.2, 4);
        api.draw2DQRCode(qr, 1, 1, 25);
        api.commitJob();
    }

    public void printQr75_50(String title, String qr, String txt) {
        api.startJob(75, 50, 0);
        api.drawTextRegular(title, 2, 1, 70, 6, 6, 1);
        api.drawTextRegular(txt, 43, 8, 32, 42, 4, 4);
        api.draw2DQRCode(qr, 2, 8, 40);
        api.commitJob();
    }
}
