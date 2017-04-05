package com.googry.bluetoothsender.ui.datasender;

import android.bluetooth.BluetoothDevice;

import com.googry.bluetoothsender.base.BasePresenter;
import com.googry.bluetoothsender.base.BaseView;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public interface DataSenderContract {

    interface Presenter extends BasePresenter{
        void connect(BluetoothDevice device);
        void disconnect();
        void sendData(String data);
    }

    interface View extends BaseView<Presenter>{
        void onClickSendData(android.view.View view);
    }

}
