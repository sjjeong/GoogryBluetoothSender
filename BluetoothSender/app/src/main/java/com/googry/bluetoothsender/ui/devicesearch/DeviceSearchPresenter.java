package com.googry.bluetoothsender.ui.devicesearch;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DeviceSearchPresenter implements DeviceSearchContract.Presenter {
    private DeviceSearchContract.View view;

    @Override
    public void start() {

    }

    public DeviceSearchPresenter(DeviceSearchContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }
}
