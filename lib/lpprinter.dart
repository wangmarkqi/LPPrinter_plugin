import 'dart:async';

import 'package:flutter/services.dart';

class Lpprinter {
  static const MethodChannel _channel =
      const MethodChannel('lpprinter');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
  static Future<String> printQr(String title,String qr,String txt) async {
    final String a = await _channel.invokeMethod('printQr40_30',{"title":title,"qr":qr,"txt":txt});
    return a;
  }

  static Future<String> printQr75_50(String title,String qr,String txt) async {
    final String a = await _channel.invokeMethod('printQr75_50',{"title":title,"qr":qr,"txt":txt});
    return a;
  }
}
