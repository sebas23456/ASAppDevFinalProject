package com.example.asappdevfinalproject.ui.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritesViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public FavoritesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is favorite fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

