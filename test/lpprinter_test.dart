import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:lpprinter/lpprinter.dart';

void main() {
  const MethodChannel channel = MethodChannel('lpprinter');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    var s=await Lpprinter.platformVersion;
    print(s);
  });
  test('hello', () async {
    String a = await channel.invokeMethod('hello',"thisisargs");
    print(a);
  });
}
