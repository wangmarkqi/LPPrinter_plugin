import 'dart:async';

import 'package:flutter/services.dart';

class Lpprinter {
  static const MethodChannel _channel =
      const MethodChannel('lpprinter');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
  static Future<String> hello() async {
    final String a = await _channel.invokeMethod('hello',"thisisargs");
    return a;
  }
}
