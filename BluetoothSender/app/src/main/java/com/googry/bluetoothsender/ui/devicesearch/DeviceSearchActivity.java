package com.googry.bluetoothsender.ui.devicesearch;

import android.support.v4.app.Fragment;

import com.googry.bluetoothsender.R;
import com.googry.bluetoothsender.base.ui.BaseActivity;


/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DeviceSearchActivity extends BaseActivity {
    private DeviceSearchPresenter presenter;
    private DeviceSearchFragment fragment;

    @Override
    protected int setLayoutId() {
        return R.layout.device_search_act;
    }

    @Override
    protected int setFragmentContentId() {
        return R.id.contentFrame;
    }

    @Override
    protected Fragment setFragment() {
        return DeviceSearchFragment.newInstance();
    }

    @Override
    protected void initView() {
        fragment = (DeviceSearchFragment) getFragment();
        presenter = new DeviceSearchPresenter(fragment);
    }
}
