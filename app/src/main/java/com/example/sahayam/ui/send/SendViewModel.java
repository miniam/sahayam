package com.example.sahayam.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("The address of the clinic is\nMathura Road, Gautam Puri\n" +
                "Sarita Vihar, Delhi - 110076\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}