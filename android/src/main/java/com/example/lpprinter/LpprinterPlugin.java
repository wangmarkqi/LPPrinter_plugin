package com.example.lpprinter;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import com.example.utils.Qr;

import com.example.utils.Qr;

/** LpprinterPlugin */
public class LpprinterPlugin implements FlutterPlugin, MethodCallHandler {

  private MethodChannel channel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "lpprinter");
    channel.setMethodCallHandler(this);
  }

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "lpprinter");
    channel.setMethodCallHandler(new LpprinterPlugin());
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
      return;
    }
    if (call.method.equals("printQr")) {
      String  title= call.argument("title");
      String qr= call.argument("qr");
      String txt= call.argument("txt");
      Qr q=new Qr();
      q.onCreate();
      q.printQr(title,qr,txt);
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
    result.notImplemented();
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
