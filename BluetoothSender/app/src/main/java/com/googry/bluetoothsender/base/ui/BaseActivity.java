package com.googry.bluetoothsender.base.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by seokjunjeong on 2017. 3. 29..
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        unbinder = ButterKnife.bind(this);
        fragment = getSupportFragmentManager()
                .findFragmentById(setFragmentContentId());
        if (fragment == null) {
            fragment = setFragment();
            FragmentTransaction transaction =
                    getSupportFragmentManager()
                            .beginTransaction();
            transaction.add(setFragmentContentId(), fragment);
            transaction.commit();
        }
        initView();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    protected Fragment getFragment() {
        return fragment;
    }

    @LayoutRes
    protected abstract int setLayoutId();

    protected abstract int setFragmentContentId();

    protected abstract Fragment setFragment();

    protected abstract void initView();


}
