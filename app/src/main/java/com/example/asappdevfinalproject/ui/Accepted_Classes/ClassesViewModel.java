package com.example.asappdevfinalproject.ui.Accepted_Classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClassesViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    public ClassesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ForYou fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
