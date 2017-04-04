package com.googry.bluetoothsender.ui.datasender;


import com.googry.bluetoothsender.R;
import com.googry.bluetoothsender.base.ui.BaseFragment;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DataSenderFragment extends BaseFragment implements DataSenderContract.View{
    private DataSenderContract.Presenter presenter;


    public static DataSenderFragment newInstance(){
        return new DataSenderFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.data_sender_frag;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setPresenter(DataSenderContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
