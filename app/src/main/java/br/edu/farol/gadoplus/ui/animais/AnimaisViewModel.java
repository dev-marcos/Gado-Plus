package br.edu.farol.gadoplus.ui.animais;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.edu.farol.gadoplus.model.Animal;
import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.repository.AnimalRepository;
import br.edu.farol.gadoplus.storage.database.repository.PropriedadeRepository;

public class AnimaisViewModel extends AndroidViewModel {

    private AnimalRepository repository;
    private LiveData<List<Animal>> allAnimals;

    public AnimaisViewModel(@NonNull Application application) {
        super(application);
        repository = new AnimalRepository(application);
        allAnimals = repository.getAll();

    }

    public void insert(Animal animal) {
        repository.insert(animal);
    }

    public void update(Animal animal) {
        repository.update(animal);
    }

    public void delete(Animal animal) {
        repository.delete(animal);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public LiveData<List<Animal>> getAll() {
        return allAnimals;
    }
}