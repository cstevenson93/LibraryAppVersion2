package com.example.libraryappversion1.ui.eContent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class eContentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public eContentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is eContent fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}