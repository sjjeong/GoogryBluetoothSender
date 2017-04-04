package com.googry.bluetoothsender.ui.devicesearch;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DeviceSearchPresenter implements DeviceSearchContract.Presenter {
    private DeviceSearchContract.View view;

    private BluetoothAdapter bluetoothAdapter;
    private ArrayList<BluetoothDevice> devices;

    public DeviceSearchPresenter(DeviceSearchContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        devices = new ArrayList<>();

        Set<BluetoothDevice> tmp = bluetoothAdapter.getBondedDevices();
        for(BluetoothDevice device : tmp){
            devices.add(device);
        }
        view.showPairedDevice(devices);
    }

    @Override
    public void startDiscovery() {
        // If we're already discovering, stop it
        if (bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }

        // Request discover from BluetoothAdapter
        bluetoothAdapter.startDiscovery();

    }

    @Override
    public void stopDiscovery() {
        bluetoothAdapter.cancelDiscovery();

    }

    @Override
    public BroadcastReceiver registerReceiver() {
        return mReceiver;
    }

    @Override
    public BroadcastReceiver unregisterReceiver() {
        // Make sure we're not doing discovery anymore
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        return mReceiver;
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                // 중복검사
                for(BluetoothDevice tmp : devices){
                    if(tmp.getAddress().equals(device.getAddress())){
                       return;
                    }
                }
                devices.add(device);
                view.showSearchedDevice(devices.size());
            }
        }
    };
}
