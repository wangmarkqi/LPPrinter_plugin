import 'package:flutter/material.dart';
import 'dart:async';

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
  String test= 'Unknown';

  @override
  void initState() {
    super.initState();
  }

  Future<void> gettest() async {
     String  _t= await Lpprinter.printQr("梧桐港","二维码内容","二维码描述");

    setState(() {
      test=_t;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(test),
        ),
        body: Center(
          child: new MaterialButton(
            color: Colors.blue,
            textColor: Colors.white,
            child: new Text('点我'),
            onPressed: () {
              gettest();
            },
          ),
        ),
      ),
    );
  }
}
