package com.example.asappdevfinalproject.ui.for_you;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ForYouViewModel extends ViewModel{

    private MutableLiveData<String> mText;

    public ForYouViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ForYou fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
