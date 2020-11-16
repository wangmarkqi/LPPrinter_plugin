import 'package:flutter/material.dart';
import 'dart:async';
import "dart:developer" as dev;
import 'package:flutter/services.dart';
import 'package:lpprinter/lpprinter.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      platformVersion = await Lpprinter.platformVersion;
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }
    if (!mounted) return;
    setState(() {
      _platformVersion = platformVersion;
    });
  }

  Future<void> gettest() async {
//    适合40*30的标签
//     String  _t= await Lpprinter.printQr40_30("梧桐港","二维码内容","二维码描述");
//    适合75*50的标签
  dev.log("aaaaaaaaaaaaaaaa");
    String _t =
        await Lpprinter.printQr75_50("中信梧桐港供应链管理有限公司", "二维码内容", "二维码描述");
    dev.log("message$_t");

  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: new MaterialButton(
            color: Colors.blue,
            textColor: Colors.white,
            child: new Text('点我'),
            onPressed: () async{
              await gettest();
            },
          ),
        ),
      ),
    );
  }
}
