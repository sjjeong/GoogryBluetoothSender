package com.googry.bluetoothsender.ui.datasender;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.view.View;
import android.widget.EditText;

import com.googry.bluetoothsender.R;
import com.googry.bluetoothsender.base.ui.BaseFragment;
import com.googry.bluetoothsender.common.Constant;
import com.googry.bluetoothsender.databinding.DataSenderFragBinding;

import butterknife.BindView;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DataSenderFragment extends BaseFragment implements DataSenderContract.View {

    @BindView(R.id.et_data)
    EditText et_data;

    private DataSenderContract.Presenter presenter;


    public static DataSenderFragment newInstance() {
        return new DataSenderFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.data_sender_frag;
    }

    @Override
    public void initView() {
        BluetoothDevice device = getActivity()
                .getIntent()
                .getParcelableExtra(Constant.ActivityExtraKey.BLUETOOTH_DEVICE);
        DataSenderFragBinding binding = (DataSenderFragBinding) getDataBinding();
        binding.setSender(BluetoothAdapter.getDefaultAdapter());
        binding.setReceiver(device);
        binding.setPresenter(presenter);
        binding.setView(this);

        presenter.start();
    }

    @Override
    public void setPresenter(DataSenderContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onClickSendData(View view) {
        String data = et_data.getText().toString();
        if (!data.isEmpty() && !data.equals(""))
            presenter.sendData(data);
    }
}
