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
    gettest();
  }

  Future<void> gettest() async {
     String  _t= await Lpprinter.hello();

    setState(() {
      test=_t;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('res: $test\n'),
        ),
      ),
    );
  }
}
