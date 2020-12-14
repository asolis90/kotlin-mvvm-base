package com.asolis.kotlinmvvmbase.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.asolis.kotlinmvvmbase.ui.ActivityListener;


public abstract class BaseFragment extends Fragment implements ActivityListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
