package com.soict.hoangviet.communicatebetweenfragmentandactivity.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> inputLiveData;

    public MutableLiveData<Integer> getInputLiveData() {
        if (inputLiveData == null) inputLiveData = new MutableLiveData<>();
        return inputLiveData;
    }
}
