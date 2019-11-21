package br.edu.farol.gadoplus.ui.pesagem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PesagemViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PesagemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Vamos pesar os bois??");
    }

    public LiveData<String> getText() {
        return mText;
    }
}