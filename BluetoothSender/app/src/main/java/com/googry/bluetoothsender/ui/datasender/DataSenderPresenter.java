package com.googry.bluetoothsender.ui.datasender;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.googry.bluetoothsender.util.bluetooth.BluetoothService;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DataSenderPresenter implements DataSenderContract.Presenter {
    private DataSenderContract.View view;
    private BluetoothService bluetoothService;

    // Bluetooth Message Handler
    private Handler bluetoothMessageHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
//                case Constant.BluetoothMessageHandlerType.TOAST:{
//                    view.showToast(
//                            msg.getData().getString(
//                                    Constant.BluetoothMessageType.TOAST
//                            )
//                    );
//                }
//                break;
//                case Constant.BluetoothMessageHandlerType.DATA:{
//                    view.startPaymentReadyActivity(
//                            msg.getData().getString(
//                                    Constant.BluetoothMessageType.DATA
//                            )
//                    );
//                }
//                break;
            }

        }
    };

    public DataSenderPresenter(DataSenderContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        bluetoothService = new BluetoothService(bluetoothMessageHandler);
    }

    @Override
    public void connect(BluetoothDevice device) {
        bluetoothService.connect(device, true);
    }

    @Override
    public void disconnect() {
        bluetoothService.stop();
    }

    @Override
    public void sendData(String data) {
        if( data.length() > 0){
            byte[] send = data.getBytes();
            bluetoothService.write(send);
        }
    }
}
