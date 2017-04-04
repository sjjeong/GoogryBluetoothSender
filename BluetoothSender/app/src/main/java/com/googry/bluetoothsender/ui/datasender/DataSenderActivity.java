package com.googry.bluetoothsender.ui.datasender;

import android.support.v4.app.Fragment;

import com.googry.bluetoothsender.R;
import com.googry.bluetoothsender.base.ui.BaseActivity;


/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DataSenderActivity extends BaseActivity {
    private DataSenderPresenter dataSenderPresenter;
    private DataSenderFragment dataSenderFragment;


    @Override
    protected int setLayoutId() {
        return R.layout.data_sender_act;
    }

    @Override
    protected int setFragmentContentId() {
        return R.id.contentFrame;
    }

    @Override
    protected Fragment setFragment() {
        return DataSenderFragment.newInstance();
    }

    @Override
    protected void initView() {
        dataSenderFragment = (DataSenderFragment) getFragment();
        dataSenderPresenter = new DataSenderPresenter(dataSenderFragment);

    }
}
