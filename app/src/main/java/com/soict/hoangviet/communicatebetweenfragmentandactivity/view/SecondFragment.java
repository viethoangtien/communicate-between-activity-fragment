package com.soict.hoangviet.communicatebetweenfragmentandactivity.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.soict.hoangviet.communicatebetweenfragmentandactivity.R;
import com.soict.hoangviet.communicatebetweenfragmentandactivity.databinding.FragmentSecondBinding;
import com.soict.hoangviet.communicatebetweenfragmentandactivity.viewmodel.MainViewModel;

public class SecondFragment extends Fragment {
    FragmentSecondBinding binding;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        binding.setLifecycleOwner(this.getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
    }

    private void initData() {
        mainViewModel.getInputLiveData().observe(this, input -> {
            binding.tvResult.setText("2 x " + input + " = " + 2 * input);
        });
    }

    private void initView() {
        initViewModel();
    }

    private void initViewModel() {
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    }
}
