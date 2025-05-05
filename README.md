# @bservan/react-native-usb-serialport-for-android

React Native USB serialport module for Android platform based on [mik3y/usb-serial-for-android](https://github.com/mik3y/usb-serial-for-android)

## Installation

```sh
npm install @bservan/react-native-usb-serialport-for-android --save
```

## Usage

```js
import { UsbSerialManager, Parity, Codes } from "@bservan/react-native-usb-serialport-for-android";

// ...
const devices = await UsbSerialManager.list();

try {
  await UsbSerialManager.tryRequestPermission(2004);
  const usbSerialport = await UsbSerialManager.open(2004, { baudRate: 38400, parity: Parity.None, dataBits: 8, stopBits: 1 });

  const sub = usbSerialport.onReceived((event) => {
    console.log(event.deviceId, event.data);
  });
  // unsubscribe
  // sub.remove();

  await usbSerialport.send('00FF');
  
  usbSerialport.close();
} catch(err) {
  console.log(err);
  if (err.code === Codes.DEVICE_NOT_FOND) {
    // ...
  }
}
```

See [documentation](https://bastengao.com/react-native-usb-serialport-for-android/) for details.

## Lifecycle-aware support

Starting with 0.6.0, lifecycle-awareness is integrated into the module. By default, this feature is not enabled. To enable it, set LIFECYCLE_AWARE_USB_MODULE_ENABLED to true in your application's properties. Easiest way to do this is by adding LIFECYCLE_AWARE_USB_MODULE_ENABLED=true to gradle.properties.

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
