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

    public static class BluetoothMessageType{
        public static final int MESSAGE_STATE_CHANGE = 1;
        public static final int MESSAGE_READ = 2;
        public static final int MESSAGE_WRITE = 3;
        public static final int MESSAGE_DEVICE_NAME = 4;
        public static final int MESSAGE_TOAST = 5;
    }
}
