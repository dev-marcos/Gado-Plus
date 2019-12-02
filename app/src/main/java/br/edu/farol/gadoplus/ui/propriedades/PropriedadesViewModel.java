package br.edu.farol.gadoplus.ui.propriedades;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.AppDatabase;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;
import br.edu.farol.gadoplus.storage.database.repository.PropriedadeRepository;

public class PropriedadesViewModel extends AndroidViewModel {

    private PropriedadeRepository repository;
    private LiveData<List<Propriedade>> allPropriedades;

    public PropriedadesViewModel(@NonNull Application application) {
        super(application);
        repository = new PropriedadeRepository(application);
        allPropriedades = repository.getAll();


       // mText = new MutableLiveData<>();
      //  mText.setValue("Você não possui propriedades");

        //dao =  AppDatabase.getInstance().propriedadeDao();

    }

    public void insert(Propriedade propriedade) {
        repository.insert(propriedade);
    }

    public void update(Propriedade propriedade) {
        repository.update(propriedade);
    }

    public void delete(Propriedade propriedade) {
        repository.delete(propriedade);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public LiveData<List<Propriedade>> getAll() {
        return allPropriedades;
    }


/*
    public List<Propriedade> getPropriedades() {
        mPropriedades = dao.getAll();
        return mPropriedades;
    }*/
}

/*
 PropriedadeDao dao;


        dao =  AppDatabase.getInstance(getContext()).propriedadeDao();



        Propriedade p = new Propriedade();
        p.setNome("Teste");
        p.setDescricao("ok");
        p.setHectares(12);
        p.setId(1);

        Propriedade p1 = new Propriedade();
        p1.setNome("Fazenda Feliz");
        p1.setDescricao("Esta é uma linda Fazenda");
        p1.setHectares(30);
        p1.setId(2);


        dao.insert(p);
        dao.insert(p1);

        p1.setNome("Mais 1");
        p1.setDescricao("Esta é duma linda Fazena");
        p1.setHectares(30);
        p1.setId(3);

        dao.insert(p1);

        p1.setNome("Mais 4");
        p1.setId(4);
        dao.insert(p1);

        p1.setNome("Mais 5");
        p1.setId(5);
        dao.insert(p1);




        PropriedadeAdapter adapter = new PropriedadeAdapter(dao.getAll());
        recyclerView.setAdapter(adapter);



 */