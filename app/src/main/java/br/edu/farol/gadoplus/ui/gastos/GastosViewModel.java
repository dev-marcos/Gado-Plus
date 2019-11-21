package br.edu.farol.gadoplus.ui.gastos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GastosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GastosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento de Gastos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}