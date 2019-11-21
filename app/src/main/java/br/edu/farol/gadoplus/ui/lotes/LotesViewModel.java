package br.edu.farol.gadoplus.ui.lotes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LotesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LotesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento de Lotes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}