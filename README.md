# lpprinter

LP priter flutter plugin

## Getting Started

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android and/or iOS.

For help getting started with Flutter, view our 
[online documentation](https://flutter.dev/docs), which offers tutorials, 
samples, guidance on mobile development, and a full API reference.


DothanTech 道臻蓝牙热敏标签打印机flutter 安卓接口包。调用printQr，printQr75_50传入title，二维码值，二维码文字说明三个字符串参数即可。详细看example下lib main.dart
 ```
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
 //    适合40*30的标签
 //     String  _t= await Lpprinter.printQr("梧桐港","二维码内容","二维码描述");
 //    适合75*50的标签
     String  _t= await Lpprinter.printQr75_50("中信梧桐港供应链管理有限公司","二维码内容","二维码描述");

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

 ```