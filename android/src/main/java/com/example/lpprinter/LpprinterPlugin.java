package com.example.lpprinter;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import com.example.lpprinter.Qr;

/**
 * LpprinterPlugin
 */
public class LpprinterPlugin implements FlutterPlugin, MethodCallHandler {
    private MethodChannel channel;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "lpprinter");
        channel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        if (call.method.equals("getPlatformVersion")) {
            result.success("Android " + android.os.Build.VERSION.RELEASE);
            return;
        }
        if (call.method.equals("printQr40_30")) {
            String  title= call.argument("title");
            String qr= call.argument("qr");
            String txt= call.argument("txt");
            Qr q=new Qr();
            q.onCreate();
            q.printQr40_30(title,qr,txt);
            result.success("success");
            return;
        }
        if (call.method.equals("printQr75_50")) {
            String  title= call.argument("title");
            String qr= call.argument("qr");
            String txt= call.argument("txt");
            Qr q=new Qr();
            q.onCreate();
            q.printQr75_50(title,qr,txt);
            result.success("success");
            return;
        }

        if (call.method.equals("printQr70_50")) {
            String  title= call.argument("title");
            String qr= call.argument("qr");
            String txt= call.argument("txt");
            Qr q=new Qr();
            q.onCreate();
            q.printQr70_50(title,qr,txt);
            result.success("success");
            return;
        }
        result.notImplemented();

    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }
}
