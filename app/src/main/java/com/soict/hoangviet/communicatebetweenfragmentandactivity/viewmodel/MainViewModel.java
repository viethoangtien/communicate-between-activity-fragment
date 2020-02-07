package com.soict.hoangviet.communicatebetweenfragmentandactivity.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> inputLiveData;
    private MutableLiveData<String> input;

    public MutableLiveData<Integer> getInputLiveData() {
        if (inputLiveData == null) inputLiveData = new MutableLiveData<>();
        return inputLiveData;
    }

    public MutableLiveData<String> getInput() {
        if (input == null) input = new MutableLiveData<>();
        return input;
    }
}
