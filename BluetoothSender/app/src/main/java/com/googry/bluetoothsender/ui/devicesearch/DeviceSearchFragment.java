package com.googry.bluetoothsender.ui.devicesearch;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Interpolator;

import com.googry.bluetoothsender.R;
import com.googry.bluetoothsender.base.ui.BaseFragment;
import com.googry.bluetoothsender.databinding.DeviceSearchFragBinding;

import java.util.ArrayList;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DeviceSearchFragment extends BaseFragment implements DeviceSearchContract.View {

    @BindView(R.id.rv_devices)
    RecyclerView rv_devices;

    private DeviceSearchAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private DeviceSearchContract.Presenter presenter;

    private DeviceSearchFragBinding binding;


    public static DeviceSearchFragment newInstance(){
        return new DeviceSearchFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.device_search_frag;
    }

    @Override
    public void initView() {
        // set DataBinding
        binding = (DeviceSearchFragBinding) getDataBinding();
        binding.setPresenter(presenter);
        binding.setAdapter(BluetoothAdapter.getDefaultAdapter());

        // setting RecyclerView
        rv_devices.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rv_devices.setLayoutManager(layoutManager);
        adapter = new DeviceSearchAdapter(new ArrayList<BluetoothDevice>(0), getContext());
        rv_devices.setAdapter(adapter);
        rv_devices.setItemAnimator(new SlideInRightAnimator());

        // Register for broadcasts when a device is discovered
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        getActivity().registerReceiver(presenter.registerReceiver(), filter);


        // Request permissions
        ActivityCompat.requestPermissions(getActivity(),new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},1);

        // start presenter
        presenter.start();
    }

    @Override
    public void setPresenter(DeviceSearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroyView() {
        // Unregister broadcast listeners
        getActivity().unregisterReceiver(presenter.unregisterReceiver());

        super.onDestroyView();
    }

    @Override
    public void showPairedDevice(ArrayList<BluetoothDevice> devices) {
        adapter.replaceData(devices);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showSearchedDevice(int position) {
        adapter.notifyItemInserted(position);
    }

}
