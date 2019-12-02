package br.edu.farol.gadoplus.ui.animais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.adapter.PropriedadeAdapter;
import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.AppDatabase;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;


public class AnimaisAddEditActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais_add_edit);


    }

}
