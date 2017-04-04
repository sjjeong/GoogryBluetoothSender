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
    private Unbinder mUnbinder;
    private Fragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mFragment = getSupportFragmentManager()
                .findFragmentById(setFragmentContentId());
        if (mFragment == null) {
            mFragment = setFragment();
            FragmentTransaction transaction =
                    getSupportFragmentManager()
                            .beginTransaction();
            transaction.add(setFragmentContentId(), mFragment);
            transaction.commit();
        }
        initView();
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }

    protected Fragment getFragment() {
        return mFragment;
    }

    @LayoutRes
    protected abstract int setLayoutId();

    protected abstract int setFragmentContentId();

    protected abstract Fragment setFragment();

    protected abstract void initView();


}
