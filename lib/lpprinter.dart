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
    final String a = await _channel.invokeMethod('printQr',{"title":title,"qr":qr,"txt":txt});
    return a;
  }
}
