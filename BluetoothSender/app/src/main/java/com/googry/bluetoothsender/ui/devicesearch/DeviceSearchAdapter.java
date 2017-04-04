package com.googry.bluetoothsender.ui.devicesearch;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.googry.bluetoothsender.R;
import com.googry.bluetoothsender.common.Constant;
import com.googry.bluetoothsender.databinding.DeviceItemBinding;
import com.googry.bluetoothsender.ui.datasender.DataSenderActivity;

import java.util.ArrayList;

/**
 * Created by seokjunjeong on 2017. 4. 4..
 */

public class DeviceSearchAdapter extends RecyclerView.Adapter<DeviceSearchAdapter.ViewHolder> {

    private ArrayList<BluetoothDevice> devices;
    private Context context;

    public DeviceSearchAdapter(ArrayList<BluetoothDevice> devices, Context context) {
        this.devices = devices;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.setData(devices.get(position));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DataSenderActivity.class);
                intent.putExtra(Constant.ActivityExtraKey.BLUETOOTH_DEVICE, devices.get(holder.getAdapterPosition()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void replaceData(ArrayList<BluetoothDevice> devices){
        this.devices = devices;
    }

    public void addDevice(BluetoothDevice device){
        devices.add(device);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        DeviceItemBinding binding;
        View view;


        public ViewHolder(View itemView) {
            super(itemView);
            binding = DeviceItemBinding.bind(itemView);
            view = itemView;
        }

        public void setData(BluetoothDevice device) {
            binding.setDevice(device);
        }
    }
}
