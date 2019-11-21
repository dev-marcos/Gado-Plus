package br.edu.farol.gadoplus.ui.animais;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnimaisViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AnimaisViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento de Animais");
    }

    public LiveData<String> getText() {
        return mText;
    }
}