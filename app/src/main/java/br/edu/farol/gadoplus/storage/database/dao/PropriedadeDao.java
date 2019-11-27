package br.edu.farol.gadoplus.storage.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.farol.gadoplus.model.Propriedade;

@Dao
public interface PropriedadeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Propriedade propriedade);

    @Delete
    void delete(Propriedade propriedade);

    @Update
    void update(Propriedade propriedade);

    @Query("SELECT * FROM propriedade WHERE id = :noteId")
    Propriedade getById(int noteId);

    @Query("SELECT * from propriedade ORDER BY nome ASC")
    List<Propriedade> getAll();

}