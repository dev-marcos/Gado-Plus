package br.edu.farol.gadoplus.ui.propriedades;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.edu.farol.gadoplus.R;

public class PropriedadesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PropriedadesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Você não possui propriedades");

    }

    public LiveData<String> getText() {
        return mText;
    }
}