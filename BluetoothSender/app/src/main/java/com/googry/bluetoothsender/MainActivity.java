package com.googry.bluetoothsender;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.googry.bluetoothsender.common.Constant;
import com.googry.bluetoothsender.ui.devicesearch.DeviceSearchActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null){
            Toast.makeText(getApplicationContext(), "Bluetooth is not available", Toast.LENGTH_SHORT).show();
            finish();
        }
        if(!bluetoothAdapter.isEnabled()){
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, Constant.ActivityRequestCode.REQUEST_ENABLE_BT);
        } else {
            startNextActivity();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case Constant.ActivityRequestCode.REQUEST_ENABLE_BT:{
                if(resultCode == RESULT_OK){
                    startNextActivity();
                } else {
                    finish();
                }
            }
            break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void startNextActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), DeviceSearchActivity.class));
                finish();
            }
        }, 0);
    }
}
