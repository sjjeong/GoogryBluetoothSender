package com.googry.bluetoothsender.ui.devicesearch;


import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;

import com.googry.bluetoothsender.base.BasePresenter;
import com.googry.bluetoothsender.base.BaseView;

import java.util.ArrayList;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public interface DeviceSearchContract {

    interface Presenter extends BasePresenter {
        void startDiscovery();
        void stopDiscovery();
        BroadcastReceiver registerReceiver();
        BroadcastReceiver unregisterReceiver();
    }

    interface View extends BaseView<Presenter> {
        void showPairedDevice(ArrayList<BluetoothDevice> devices);
        void showSearchedDevice(int position);
    }

}
