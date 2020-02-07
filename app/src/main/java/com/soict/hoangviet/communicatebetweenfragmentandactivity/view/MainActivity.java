package com.soict.hoangviet.communicatebetweenfragmentandactivity.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.soict.hoangviet.communicatebetweenfragmentandactivity.R;
import com.soict.hoangviet.communicatebetweenfragmentandactivity.databinding.ActivityMainBinding;
import com.soict.hoangviet.communicatebetweenfragmentandactivity.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mainViewModel.getInputLiveData().observe(this, input -> {
            binding.tvShowInput.setText("Your input is " + input);
        });
    }

    private void initData() {

    }

    private void initView() {
        initViewModel();
        initFragment();
    }

    private void initFragment() {
        try {
            FirstFragment firstFragment = FirstFragment.class.newInstance();
            SecondFragment secondFragment = SecondFragment.class.newInstance();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fl_container_first, firstFragment, "FirstFragment");
            fragmentTransaction.add(R.id.fl_container_second, secondFragment, "SecondFragment");
            fragmentTransaction.commitAllowingStateLoss();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void initViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }
}
