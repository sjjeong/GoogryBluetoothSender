package com.googry.bluetoothsender.ui.datasender;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DataSenderPresenter implements DataSenderContract.Presenter {
    private DataSenderContract.View view;

    public DataSenderPresenter(DataSenderContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
