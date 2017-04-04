package com.googry.bluetoothsender.ui.devicesearch;


import com.googry.bluetoothsender.R;
import com.googry.bluetoothsender.base.ui.BaseFragment;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DeviceSearchFragment extends BaseFragment implements DeviceSearchContract.View {
    private DeviceSearchContract.Presenter presenter;


    public static DeviceSearchFragment newInstance(){
        return new DeviceSearchFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.device_search_frag;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setPresenter(DeviceSearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onStart() {

        super.onStart();
    }
}
