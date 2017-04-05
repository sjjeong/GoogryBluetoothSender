package com.googry.bluetoothsender.common;

/**
 * Created by seokjunjeong on 2017. 3. 27..
 */

public class Constant {

    public static class ActivityRequestCode {
        public static final int REQUEST_ENABLE_BT = 1;
    }

    public static class ActivityExtraKey{
        public static final String BLUETOOTH_DEVICE = "bluetooth_device";
    }

    public static class BluetoothMessageType {
        public static final String DATA = "data";
        public static final String TOAST = "toast";
    }

    public static class BluetoothMessageHandlerType{
        public static final int DATA = 1;
        public static final int TOAST = 2;
    }
}
