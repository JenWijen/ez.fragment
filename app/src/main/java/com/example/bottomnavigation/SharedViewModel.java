package com.example.bottomnavigation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> selectedData = new MutableLiveData<>();

    public void selectData(String data) {
        selectedData.setValue(data);
    }

    public LiveData<String> getSelectedData() {
        return selectedData;
    }
}
