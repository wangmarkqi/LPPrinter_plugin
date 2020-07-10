package com.example.utils;


import com.dothantech.lpapi.LPAPI;
import com.dothantech.lpapi.IAtBitmap.DrawParamName;
import com.dothantech.lpapi.LPAPI.Factory;

public class Qr {
    private LPAPI api;
    public void onCreate(){
        new LPAPI.Factory();
        // 初始化 LPAPI 对象（简单起见，不处理结果通知）
        api = Factory.createInstance();
    }
    public void onDestroy(){
        // 断开蓝牙连接，释放 LPAPI 对象
        api.quit();
    }
    private void printText(String content) {
        // 连接配对的第一个打印机对象
        api.openPrinter(null);

        // 开始绘图任务，传入参数(页面宽度, 页面高度)
        api.startJob(40, 30, 0);

        // 开始一个页面的绘制，绘制文本字符串
        api.drawText(content, 4, 5, 40, 30, 4);

        // 结束绘图任务提交打印
        api.commitJob();
    }

    private void printQRcode(String content) {
        // 连接配对的第一个打印机对象
        api.openPrinter(null);

        // 开始绘图任务，传入参数(页面宽度, 页面高度)
        api.startJob(40, 30, 0);

        // 开始一个页面的绘制，绘制二维码
        api.draw2DQRCode(content, 4, 5, 20);

        // 结束绘图任务提交打印
        api.commitJob();
    }
}
