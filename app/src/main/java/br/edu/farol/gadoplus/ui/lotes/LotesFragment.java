package br.edu.farol.gadoplus.ui.lotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import br.edu.farol.gadoplus.R;

public class LotesFragment extends Fragment {

    private LotesViewModel lotesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lotesViewModel =
                ViewModelProviders.of(this).get(LotesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lotes, container, false);
        //final TextView textView = root.findViewById(R.id.text_lotes);
        lotesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        return root;
    }
}