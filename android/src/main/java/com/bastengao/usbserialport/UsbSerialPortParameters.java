package com.bastengao.usbserialport;

import com.hoho.android.usbserial.driver.UsbSerialPort.Parity;

class UsbSerialPortParameters {
    int baudRate;
    int dataBits;
    int stopBits;
    @Parity
    int parity;

    UsbSerialPortParameters(int baudRate, int dataBits, int stopBits, @Parity int parity) {
        this.baudRate = baudRate;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
    }
}
